package com.zlsoft.model.entity;

import javax.persistence.*;

public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 备注内容
     */
    private String content;

    /**
     * 病区id
     */
    @Column(name = "ward_id")
    private String wardId;

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
     * 获取备注内容
     *
     * @return content - 备注内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置备注内容
     *
     * @param content 备注内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取病区id
     *
     * @return ward_id - 病区id
     */
    public String getWardId() {
        return wardId;
    }

    /**
     * 设置病区id
     *
     * @param wardId 病区id
     */
    public void setWardId(String wardId) {
        this.wardId = wardId;
    }
}