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
}