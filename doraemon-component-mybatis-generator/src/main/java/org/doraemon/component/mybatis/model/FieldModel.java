package org.doraemon.component.mybatis.model;

import java.io.Serializable;

/**
 * created with IntelliJ IDEA.
 * description: 描述
 * author:      fengwenping
 * date:        2019/6/30 23:46
 */
public class FieldModel implements Serializable {

    private Integer pk;

    /**
     * 名称
     */
    private String name;

    /**
     * 列名
     */
    private String columnName;

    /**
     * 属性名
     */
    private String propertyName;
    /**
     * java数据类型
     */
    private String javaType;

    /**
     * 数据库数据类型
     */
    private String jdbcType;
    /**
     * 描述
     */
    private String comment;

    public Integer getPk() {
        return pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
}
