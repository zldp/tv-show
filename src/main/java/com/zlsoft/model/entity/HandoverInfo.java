package com.zlsoft.model.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "handover_info")
public class HandoverInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 病区ID
     */
    @Column(name = "ward_id")
    private Integer wardId;

    /**
     * 病人ID
     */
    @Column(name = "patient_id")
    private Integer patientId;

    /**
     * 主页ID
     */
    @Column(name = "index_id")
    private Integer indexId;

    /**
     * 床号
     */
    @Column(name = "bed_no")
    private String bedNo;

    /**
     * 病人姓名
     */
    @Column(name = "patient_name")
    private String patientName;

    /**
     * 发布时间
     */
    @Column(name = "publish_time")
    private Date publishTime;

    /**
     * 发布班次
     */
    @Column(name = "publish_class")
    private String publishClass;

    /**
     * 发布护士ID
     */
    @Column(name = "publish_nurse_id")
    private String publishNurseId;

    /**
     * 发布护士姓名
     */
    @Column(name = "publish_nurse_name")
    private String publishNurseName;

    /**
     * 交班内容
     */
    @Column(name = "handover_content")
    private String handoverContent;

    /**
     * 接收时间
     */
    @Column(name = "receive_time")
    private Date receiveTime;

    /**
     * 接收班次
     */
    @Column(name = "receive_class")
    private String receiveClass;

    /**
     * 接收护士ID
     */
    @Column(name = "receive_nurse_id")
    private String receiveNurseId;

    /**
     * 接收护士姓名
     */
    @Column(name = "receive_nurse_name")
    private String receiveNurseName;

    /**
     * 状态 0:未接收 1:已接收
     */
    private Integer state;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取病区ID
     *
     * @return ward_id - 病区ID
     */
    public Integer getWardId() {
        return wardId;
    }

    /**
     * 设置病区ID
     *
     * @param wardId 病区ID
     */
    public void setWardId(Integer wardId) {
        this.wardId = wardId;
    }

    /**
     * 获取病人ID
     *
     * @return patient_id - 病人ID
     */
    public Integer getPatientId() {
        return patientId;
    }

    /**
     * 设置病人ID
     *
     * @param patientId 病人ID
     */
    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    /**
     * 获取主页ID
     *
     * @return index_id - 主页ID
     */
    public Integer getIndexId() {
        return indexId;
    }

    /**
     * 设置主页ID
     *
     * @param indexId 主页ID
     */
    public void setIndexId(Integer indexId) {
        this.indexId = indexId;
    }

    /**
     * 获取床号
     *
     * @return bed_no - 床号
     */
    public String getBedNo() {
        return bedNo;
    }

    /**
     * 设置床号
     *
     * @param bedNo 床号
     */
    public void setBedNo(String bedNo) {
        this.bedNo = bedNo;
    }

    /**
     * 获取病人姓名
     *
     * @return patient_name - 病人姓名
     */
    public String getPatientName() {
        return patientName;
    }

    /**
     * 设置病人姓名
     *
     * @param patientName 病人姓名
     */
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    /**
     * 获取发布时间
     *
     * @return publish_time - 发布时间
     */
    public Date getPublishTime() {
        return publishTime;
    }

    /**
     * 设置发布时间
     *
     * @param publishTime 发布时间
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * 获取发布班次
     *
     * @return publish_class - 发布班次
     */
    public String getPublishClass() {
        return publishClass;
    }

    /**
     * 设置发布班次
     *
     * @param publishClass 发布班次
     */
    public void setPublishClass(String publishClass) {
        this.publishClass = publishClass;
    }

    /**
     * 获取发布护士ID
     *
     * @return publish_nurse_id - 发布护士ID
     */
    public String getPublishNurseId() {
        return publishNurseId;
    }

    /**
     * 设置发布护士ID
     *
     * @param publishNurseId 发布护士ID
     */
    public void setPublishNurseId(String publishNurseId) {
        this.publishNurseId = publishNurseId;
    }

    /**
     * 获取发布护士姓名
     *
     * @return publish_nurse_name - 发布护士姓名
     */
    public String getPublishNurseName() {
        return publishNurseName;
    }

    /**
     * 设置发布护士姓名
     *
     * @param publishNurseName 发布护士姓名
     */
    public void setPublishNurseName(String publishNurseName) {
        this.publishNurseName = publishNurseName;
    }

    /**
     * 获取交班内容
     *
     * @return handover_content - 交班内容
     */
    public String getHandoverContent() {
        return handoverContent;
    }

    /**
     * 设置交班内容
     *
     * @param handoverContent 交班内容
     */
    public void setHandoverContent(String handoverContent) {
        this.handoverContent = handoverContent;
    }

    /**
     * 获取接收时间
     *
     * @return receive_time - 接收时间
     */
    public Date getReceiveTime() {
        return receiveTime;
    }

    /**
     * 设置接收时间
     *
     * @param receiveTime 接收时间
     */
    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    /**
     * 获取接收班次
     *
     * @return receive_class - 接收班次
     */
    public String getReceiveClass() {
        return receiveClass;
    }

    /**
     * 设置接收班次
     *
     * @param receiveClass 接收班次
     */
    public void setReceiveClass(String receiveClass) {
        this.receiveClass = receiveClass;
    }

    /**
     * 获取接收护士ID
     *
     * @return receive_nurse_id - 接收护士ID
     */
    public String getReceiveNurseId() {
        return receiveNurseId;
    }

    /**
     * 设置接收护士ID
     *
     * @param receiveNurseId 接收护士ID
     */
    public void setReceiveNurseId(String receiveNurseId) {
        this.receiveNurseId = receiveNurseId;
    }

    /**
     * 获取接收护士姓名
     *
     * @return receive_nurse_name - 接收护士姓名
     */
    public String getReceiveNurseName() {
        return receiveNurseName;
    }

    /**
     * 设置接收护士姓名
     *
     * @param receiveNurseName 接收护士姓名
     */
    public void setReceiveNurseName(String receiveNurseName) {
        this.receiveNurseName = receiveNurseName;
    }

    /**
     * 获取状态 0:未接收 1:已接收
     *
     * @return state - 状态 0:未接收 1:已接收
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态 0:未接收 1:已接收
     *
     * @param state 状态 0:未接收 1:已接收
     */
    public void setState(Integer state) {
        this.state = state;
    }
}