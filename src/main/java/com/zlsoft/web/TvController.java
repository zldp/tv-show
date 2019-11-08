package com.zlsoft.web;

import com.sun.org.apache.regexp.internal.RE;
import com.sun.xml.internal.ws.api.model.MEP;
import com.zlsoft.core.Result;
import com.zlsoft.core.ResultGenerator;
import com.zlsoft.model.entity.SystemParameter;
import com.zlsoft.service.SystemParameterService;
import com.zlsoft.service.TvDatasourceFormatService;
import com.zlsoft.service.TvPageDetailService;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.mapper.entity.Condition;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dp
 * @version 1.0.0
 * @date 2019-08-08 09:01
 */

@RestController
@RequestMapping("/tv")
@Validated
public class TvController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private SystemParameterService systemParameterService;

    @Autowired
    private TvPageDetailService tvPageDetailService;

    @Autowired
    private TvDatasourceFormatService tvDatasourceFormatService;
    @Value("${api.url}")
    private String URL;

    /**
     * 检查报告列表
     * @param patientId
     * @return
     */
    @GetMapping("/report/{patientId}")
    public Result report(@PathVariable String patientId){

        return restTemplate.getForObject(URL+"/tv?patientId="+patientId,Result.class);
    }

    @GetMapping("/reportDetail")
    public Result reportDetail(String reportId){
        return restTemplate.getForObject(URL+"/vt/reportDetail?reportId="+reportId,Result.class);
    }

    /**
     * 获取医嘱信息   该接口改成从his获取
     * @param patientId
     * @param indexId
     * @param effectPeriod
     * @return
     */
    @GetMapping("/findMedicalByPatientIdAndIndexId")
    public Result findMedicalByPatientIdAndIndexId(
            @RequestParam(required = true)
            Integer patientId,
            @RequestParam(required = true)
            Integer indexId,
            @RequestParam(required = true)
            Integer effectPeriod
    ){
        Map params = new HashMap(2);
        params.put("patientId", patientId);
        params.put("indexId", indexId);
        params.put("effectPeriod", effectPeriod);
        Result forObject = restTemplate.getForObject(URL+"/tv/tvOrderShow?patientId="+patientId+"&indexId="+indexId+"&effectPeriod="+effectPeriod, Result.class);

        return forObject;
    }

    @GetMapping("/patientCost")
    public Result patientCost(
        @NotBlank(message = "patientId不能为空")
        String patientId,
        @NotBlank(message = "indexId不能为空")
        String indexId,
        @NotBlank(message = "registrationTime不能为空")
        String registrationTime
    ){
        return restTemplate.getForObject(URL + "/tv/patientCost?patientId=" + patientId + "&indexId=" + indexId + "&registrationTime=" + registrationTime, Result.class);
    }



    @GetMapping("/patientDetails")
    public Result patientDetails(
            @NotBlank(message = "patientId不能为空")
            String patientId,
            @NotBlank(message = "indexId不能为空")
            String indexId
    ){
        return restTemplate.getForObject(URL+"/tv/patientDetails?patientId="+patientId+"&indexId="+indexId, Result.class);
    }


    /**
     * 检验列表
     * @param patientId
     * @return
     */
    @GetMapping("/inspectionList/{patientId}")
    public Result inspectionList(
            @PathVariable
            Integer patientId
    ){
        Condition condition = new Condition(SystemParameter.class);
        condition.createCriteria().andCondition("parameter_name=", "inspect_version");
        List<SystemParameter> list = systemParameterService.findByCondition(condition);
        return restTemplate.getForObject(URL + "/tv/inspectList?inspectVersion="+list.get(0).getParameterValue()+"&patientId=" + patientId, Result.class);
    }

    /**
     * 普通检验结果 根据上面查询结果字段ExamineType判断 0:普通 1:微生物
     * @param examineOrderId
     * @return
     */
    @GetMapping("/generalList/{examineOrderId}")
    public Result generalList(
            @PathVariable String examineOrderId
    ){
        return restTemplate.getForObject(URL + "/tv/generalList?examineOrderId=" + examineOrderId, Result.class);
    }

    /**
     * 微生物列表
     * @param examineOrderID
     * @return
     */
    @GetMapping("/microList1")
    public Result microList1(
            @NotBlank(message = "examineOrderID不能为空")
            String examineOrderID
    ){
        return restTemplate.getForObject(URL + "/tv/microList?examineOrderID=" + examineOrderID, Result.class);
    }

    /**
     * 微生物明细
     * @param microid
     * @return
     */
    @GetMapping("/micro")
    public Result micro(
            @NotBlank(message = "microid不能为空")
            String microid,
            @NotBlank(message = "examineOrderID不能为空")
            String examineOrderID
    ){
        return restTemplate.getForObject(URL + "/tv/micro?microid=" + microid + "&examineOrderID=" + examineOrderID, Result.class);
    }

    @GetMapping("/findHospitalPay")
    public Result findHospitalPay(
            @NotBlank(message = "patientId不能为空")
            String patientId,
            @NotBlank(message = "indexId不能为空")
            String indexId
    ){
        Map<String, String> stringStringMap = tvDatasourceFormatService.getTimingTime("pay_url");
        return restTemplate.getForObject(URL + "/tv/findHospitalPay?patientId=" + patientId + "&indexId=" + indexId+"&payUrl="+stringStringMap.get("parameter_value"), Result.class);
    }

    @GetMapping("/tvOrderShow")
    public Result tvOrderShow(){

        return null;
    }

    @GetMapping("/microList/{examineOrderId}")
    public Result microList(
            @PathVariable String examineOrderId
    ){
        return restTemplate.getForObject(URL + "/tv/microList?examineOrderId="+examineOrderId, Result.class);
    }


    @GetMapping("/prepayRecord/{patientId}")
    public Result prepayRecord(
            @PathVariable Integer patientId
    ){
        return restTemplate.getForObject(URL + "/tv/prepayRecord?patientId="+patientId, Result.class);
    }

    /**
     * 获取护理等级
     * @param patiendId
     * @param indexId
     * @return
     */
    @GetMapping("/getNursingGrade/{patiendId}/{indexId}")
    public Result getNursingGrade(
            @PathVariable Integer  patiendId,
            @PathVariable Integer  indexId
    ){
        Map params = new HashMap(2);
        params.put("patiendId", patiendId);
        params.put("indexId", indexId);
        return ResultGenerator.genSuccessResult(tvPageDetailService.getNursingGrade(params));
    }

    /**
     * 根据身份证或者护院号获取病人信息
     * @param no
     * @return
     */
    @GetMapping("/getPatientByNoOrHospitalNo/{no}")
    public Result getPatientByNoOrHospitalNo(
            @PathVariable String no
    ){
        return restTemplate.getForObject(URL + "/tv/getPatientByNoOrHospitalNo?no=" + no, Result.class);
    }

    /**
     * 获取任务信息  根据wardId
     * @param wardId
     * @return
     */
    @GetMapping("/getTaskOrderInfo/{wardId}")
    public Result getTaskOrderInfo(
            @PathVariable Integer wardId
    ){
        return ResultGenerator.genSuccessResult(tvPageDetailService.getTaskOrderInfo(wardId));
    }


}
