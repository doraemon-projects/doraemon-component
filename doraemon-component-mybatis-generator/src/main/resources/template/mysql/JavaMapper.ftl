package ${model.packageName}.dao;

import ${model.packageName}.bean.${model.name};
import org.doraemon.framework.base.dao.BaseDao;

/**
* Created with IntelliJ IDEA.
* Description: ${model.comment}访问数据库Dao
* Author:      fengwenping
* Date:        ${.now}
*/
public interface ${model.name!}Dao extends BaseDao<${model.name}, <#if "java.lang.String"==(model.pkField.javaType)>String<#else>Long</#if>> {
}
