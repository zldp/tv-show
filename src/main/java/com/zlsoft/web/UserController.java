package com.zlsoft.web;


import com.zlsoft.core.Result;
import com.zlsoft.core.ResultGenerator;
import com.zlsoft.exception.CustomException;
import com.zlsoft.exception.CustomUnauthorizedException;
import com.zlsoft.model.UserDto;
import com.zlsoft.model.common.BaseDto;
import com.zlsoft.model.common.Constant;
import com.zlsoft.model.group.UserEditValidGroup;
import com.zlsoft.model.group.UserLoginValidGroup;
import com.zlsoft.service.IUserService;
import com.zlsoft.util.AesCipherUtil;
import com.zlsoft.util.JedisUtil;
import com.zlsoft.util.JwtUtil;
import com.zlsoft.util.common.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * UserController
 * @author dp926454
 * @date 2018/8/29 15:45
 */
@RestController
@RequestMapping("/user")
@PropertySource("classpath:config.properties")
public class UserController {

    /**
     * RefreshToken过期时间
     */
    @Value("${refreshTokenExpireTime}")
    private String refreshTokenExpireTime;

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * 获取用户列表
     * @param
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @author dp926454
     * @date 2018/8/30 10:41
     */
    @GetMapping
    @RequiresPermissions(logical = Logical.AND, value = {"user:view"})
    public Result user(@Validated BaseDto baseDto) {
        if (baseDto.getPage() == null || baseDto.getRows() == null) {
            baseDto.setPage(1);
            baseDto.setRows(10);
        }
        PageHelper.startPage(baseDto.getPage(), baseDto.getRows());
        List<UserDto> userDtos = userService.selectAll();
        PageInfo<UserDto> selectPage = new PageInfo<UserDto>(userDtos);
        if (userDtos == null || userDtos.size() <= 0) {
            throw new CustomException("查询失败(Query Failure)");
        }
        Map<String, Object> result = new HashMap<String, Object>(16);
        result.put("count", selectPage.getTotal());
        result.put("data", selectPage.getList());
        return new Result(HttpStatus.OK.value(), "查询成功(Query was successful)", result);
    }

    /**
     * 获取在线用户(查询Redis中的RefreshToken)
     * @param
     * @return com.dp.model.common.Result
     * @author dp926454
     * @date 2018/9/6 9:58
     */
    @GetMapping("/online")
    @RequiresPermissions(logical = Logical.AND, value = {"user:view"})
    public Result online() {
        List<Object> userDtos = new ArrayList<Object>();
        // 查询所有Redis键
        Set<String> keys = JedisUtil.keysS(Constant.PREFIX_SHIRO_REFRESH_TOKEN + "*");
        for (String key : keys) {
            if (JedisUtil.exists(key)) {
                // 根据:分割key，获取最后一个字符(帐号)
                String[] strArray = key.split(":");
                UserDto userDto = new UserDto();
                userDto.setAccount(strArray[strArray.length - 1]);
                userDto = userService.selectOne(userDto);
                // 设置登录时间
                userDto.setLoginTime(new Date(Long.parseLong(JedisUtil.getObject(key).toString())));
                userDtos.add(userDto);
            }
        }
        if (userDtos == null || userDtos.size() <= 0) {
            throw new CustomException("查询失败(Query Failure)");
        }
        return new Result(HttpStatus.OK.value(), "查询成功(Query was successful)", userDtos);
    }

    /**
     * 登录授权
     * @param userDto
     * @return com.dp.model.common.Result
     * @author dp926454
     * @date 2018/8/30 16:21
     */
    @PostMapping("/login")
    public Result login(@Validated(UserLoginValidGroup.class) @RequestBody UserDto userDto, HttpServletResponse httpServletResponse) {
        // 查询数据库中的帐号信息
        UserDto userDtoTemp = new UserDto();
        userDtoTemp.setAccount(userDto.getAccount());
        userDtoTemp = userService.selectOne(userDtoTemp);
        if (userDtoTemp == null) {
            throw new CustomUnauthorizedException("该帐号不存在(The account does not exist.)");
        }
        // 密码进行AES解密
        String key = AesCipherUtil.deCrypto(userDtoTemp.getPassword());
        // 因为密码加密是以帐号+密码的形式进行加密的，所以解密后的对比是帐号+密码
        if (key.equals(userDto.getAccount() + userDto.getPassword())) {
            // 清除可能存在的Shiro权限信息缓存
            if (JedisUtil.exists(Constant.PREFIX_SHIRO_CACHE + userDto.getAccount())) {
                JedisUtil.delKey(Constant.PREFIX_SHIRO_CACHE + userDto.getAccount());
            }
            // 设置RefreshToken，时间戳为当前时间戳，直接设置即可(不用先删后设，会覆盖已有的RefreshToken)
            String currentTimeMillis = String.valueOf(System.currentTimeMillis());
            JedisUtil.setObject(Constant.PREFIX_SHIRO_REFRESH_TOKEN + userDto.getAccount(), currentTimeMillis, Integer.parseInt(refreshTokenExpireTime));
            // 从Header中Authorization返回AccessToken，时间戳为当前时间戳
            String token = JwtUtil.sign(userDto.getAccount(), currentTimeMillis);

            Map<String, Object> tokenMap = new HashMap<>();
            tokenMap.put("Authorization",token);

            httpServletResponse.setHeader("Authorization", token);
            httpServletResponse.setHeader("Access-Control-Expose-Headers", "Authorization");
            return new Result(HttpStatus.OK.value(), "登录成功(Login Success.)", tokenMap);
        } else {
            throw new CustomUnauthorizedException("帐号或密码错误(Account or Password Error.)");
        }
    }

    /**
     * 测试登录
     * @param
     * @return com.dp.model.common.Result
     * @author dp926454
     * @date 2018/8/30 16:18
     */
    @GetMapping("/article")
    public Result article() {
        Subject subject = SecurityUtils.getSubject();
        // 登录了返回true
        if (subject.isAuthenticated()) {
            return new Result(HttpStatus.OK.value(), "您已经登录了(You are already logged in)", null);
        } else {
            return new Result(HttpStatus.OK.value(), "你是游客(You are guest)", null);
        }
    }

    /**
     * 测试登录注解(@RequiresAuthentication和subject.isAuthenticated()返回true一个性质)
     * @param
     * @return com.dp.model.common.Result
     * @author dp926454
     * @date 2018/8/30 16:18
     */
    @GetMapping("/article2")
    @RequiresAuthentication
    public Result requireAuth() {
        return new Result(HttpStatus.OK.value(), "您已经登录了(You are already logged in)", null);
    }

    /**
     * 获取指定用户
     * @param id
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @author dp926454
     * @date 2018/8/30 10:42
     */
    @GetMapping("/{id}")
    @RequiresPermissions(logical = Logical.AND, value = {"user:view"})
    public Result findById(@PathVariable("id") Integer id) {
        UserDto userDto = userService.selectByPrimaryKey(id);
        if (userDto == null) {
            throw new CustomException("查询失败(Query Failure)");
        }
        return new Result(HttpStatus.OK.value(), "查询成功(Query was successful)", userDto);
    }

    /**
     * 新增用户
     * @param userDto
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @author dp926454
     * @date 2018/8/30 10:42
     */
    @PostMapping
    /*@RequiresPermissions(logical = Logical.AND, value = {"user:edit"})*/
    public Result add(@Validated(UserEditValidGroup.class) @RequestBody UserDto userDto) {
        // 判断当前帐号是否存在
        UserDto userDtoTemp = new UserDto();
        userDtoTemp.setAccount(userDto.getAccount());
        userDtoTemp = userService.selectOne(userDtoTemp);
        if (userDtoTemp != null && StringUtil.isNotBlank(userDtoTemp.getPassword())) {
            throw new CustomException("该帐号已存在(Account exist.)");
        }
        userDto.setRegTime(new Date());
        // 密码以帐号+密码的形式进行AES加密
        if (userDto.getPassword().length() > Constant.PASSWORD_MAX_LEN) {
            throw new CustomException("密码最多8位(Password up to 8 bits.)");
        }
        String key = AesCipherUtil.enCrypto(userDto.getAccount() + userDto.getPassword());
        userDto.setPassword(key);
        int count = userService.insert(userDto);
        if (count <= 0) {
            throw new CustomException("新增失败(Insert Failure)");
        }
        return new Result(HttpStatus.OK.value(), "新增成功(Insert Success)", userDto);
    }

    /**
     * 更新用户
     * @param userDto
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @author dp926454
     * @date 2018/8/30 10:42
     */
    @PutMapping
    @RequiresPermissions(logical = Logical.AND, value = {"user:edit"})

    public Result update(@Validated(UserEditValidGroup.class) @RequestBody UserDto userDto) {
        // 查询数据库密码
        UserDto userDtoTemp = new UserDto();
        userDtoTemp.setAccount(userDto.getAccount());
        userDtoTemp = userService.selectOne(userDtoTemp);
        if (userDtoTemp == null) {
            throw new CustomException("该帐号不存在(Account not exist.)");
        } else {
            userDto.setUserId(userDtoTemp.getUserId());
        }
        // FIXME: 如果不一样就说明用户修改了密码，重新加密密码(这个处理不太好，但是没有想到好的处理方式)
        if (!userDtoTemp.getPassword().equals(userDto.getPassword())) {
            // 密码以帐号+密码的形式进行AES加密
            if (userDto.getPassword().length() > Constant.PASSWORD_MAX_LEN) {
                throw new CustomException("密码最多8位(Password up to 8 bits.)");
            }
            String key = AesCipherUtil.enCrypto(userDto.getAccount() + userDto.getPassword());
            userDto.setPassword(key);
        }
        int count = userService.updateByPrimaryKeySelective(userDto);
        if (count <= 0) {
            throw new CustomException("更新失败(Update Failure)");
        }
        return new Result(HttpStatus.OK.value(), "更新成功(Update Success)", userDto);
    }

    /**
     * 删除用户
     * @param id
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @author dp926454
     * @date 2018/8/30 10:43
     */
    @DeleteMapping("/{id}")
    @RequiresPermissions(logical = Logical.AND, value = {"user:edit"})
    public Result delete(@PathVariable("id") Integer id) {
        int count = userService.deleteByPrimaryKey(id);
        if (count <= 0) {
            throw new CustomException("删除失败，ID不存在(Deletion Failed. ID does not exist.)");
        }
        return new Result(HttpStatus.OK.value(), "删除成功(Delete Success)", null);
    }

    /**
     * 剔除在线用户
     * @param id
     * @return com.dp.model.common.Result
     * @author dp926454
     * @date 2018/9/6 10:20
     */
    @DeleteMapping("/online/{id}")
    @RequiresPermissions(logical = Logical.AND, value = {"user:edit"})
    public Result deleteOnline(@PathVariable("id") Integer id) {
        UserDto userDto = userService.selectByPrimaryKey(id);
        if (JedisUtil.exists(Constant.PREFIX_SHIRO_REFRESH_TOKEN + userDto.getAccount())) {
            if (JedisUtil.delKey(Constant.PREFIX_SHIRO_REFRESH_TOKEN + userDto.getAccount()) > 0) {
                return new Result(HttpStatus.OK.value(), "剔除成功(Delete Success)", null);
            }
        }
        throw new CustomException("剔除失败，Account不存在(Deletion Failed. Account does not exist.)");
    }

    @GetMapping("/info")
    public Result userInfo(HttpServletRequest request){
        String token = request.getHeader("Authorization");

        // 获取当前Token的帐号信息
        String account = JwtUtil.getClaim(token, Constant.ACCOUNT);

        return ResultGenerator.genSuccessResult(userService.selectInfo(account));
    }
}