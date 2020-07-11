<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${model.packageName}.dao.${model.name}Dao">
    <resultMap id="BaseResultMap" type="${model.packageName}.bean.${model.name!}">
        <#list model.fields as field>
        <#if field.pk gt 0>
        <id property="id" column="${field.columnName}" javaType="${field.javaType}" jdbcType="${field.jdbcType}"/>
        <#else>
        <result property="${field.propertyName!}" column="${field.columnName}" javaType="${field.javaType}" jdbcType="${field.jdbcType}"/>
        </#if>
        </#list>
    </resultMap>

    <insert id="insert" parameterType="${model.packageName}.bean.${model.name!}">
        insert into ${model.tableName}
        (
        <#list model.fields as field>
        ${field.columnName}<#if field_has_next>,</#if>
        </#list>
        )
        values
        (
        <#list model.fields as field>
        ${r'#{'}${field.propertyName!}}<#if field_has_next>,</#if>
        </#list>
        )
    </insert>

    <insert id="insertSelective" parameterType="${model.packageName}.bean.${model.name!}">
        insert into ${model.tableName}
        (
        <#list model.fields as field>
        <if test="${field.propertyName}!=null<#if "java.lang.String"==field.javaType> and ${field.propertyName}!=''</#if>">
        ${field.columnName}<#if field_has_next>,</#if>
        </if>
        </#list>
        )
        values
        (
        <#list model.fields as field>
        <if test="${field.propertyName}!=null<#if "java.lang.String"==field.javaType> and ${field.propertyName}!=''</#if>">
        ${r'#{'}${field.propertyName!}}<#if field_has_next>,</#if>
        </if>
        </#list>
        )
    </insert>
</mapper>