package com.zlsoft.model.entity;

import com.zlsoft.model.group.UserEditValidGroup;
import com.zlsoft.model.group.UserLoginValidGroup;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * User
 * @author dp926454
 * @date 2018/8/31 14:43
 */
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 3342723124953988435L;

    /**
     * ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private String userId;

    /**
     * 帐号
     */
    @NotNull(message = "帐号不能为空", groups = { UserLoginValidGroup.class, UserEditValidGroup.class })
    private String account;

    /**
     * 密码
     */
    @NotNull(message = "密码不能为空", groups = { UserLoginValidGroup.class, UserEditValidGroup.class })
    private String password;

    /**
     * 昵称
     */
    @NotNull(message = "用户名不能为空", groups = { UserEditValidGroup.class })
    private String username;
    /**
     * 病区id
     */
    private String wardId;

    /**
     * 病区名称
     */
    private String wardName;



    /**
     * 注册时间
     */
    @Column(name = "reg_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date regTime;


    public String getWardId() {
        return wardId;
    }

    public void setWardId(String wardId) {
        this.wardId = wardId;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置ID
     *
     * @param userId ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取帐号
     *
     * @return account - 帐号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置帐号
     *
     * @param account 帐号
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取昵称
     *
     * @return username - 昵称
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置昵称
     *
     * @param username 昵称
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取注册时间
     *
     * @return reg_time - 注册时间
     */
    public Date getRegTime() {
        return regTime;
    }

    /**
     * 设置注册时间
     *
     * @param regTime 注册时间
     */
    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }
}