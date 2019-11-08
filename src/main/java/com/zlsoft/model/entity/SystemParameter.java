package com.zlsoft.model.entity;

import javax.persistence.*;

@Table(name = "system_parameter")
public class SystemParameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "parameter_caption")
    private String parameterCaption;

    @Column(name = "parameter_name")
    private String parameterName;

    @Column(name = "parameter_value")
    private String parameterValue;

    private String comments;

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
     * @return parameter_caption
     */
    public String getParameterCaption() {
        return parameterCaption;
    }

    /**
     * @param parameterCaption
     */
    public void setParameterCaption(String parameterCaption) {
        this.parameterCaption = parameterCaption;
    }

    /**
     * @return parameter_name
     */
    public String getParameterName() {
        return parameterName;
    }

    /**
     * @param parameterName
     */
    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    /**
     * @return parameter_value
     */
    public String getParameterValue() {
        return parameterValue;
    }

    /**
     * @param parameterValue
     */
    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }

    /**
     * @return comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
}