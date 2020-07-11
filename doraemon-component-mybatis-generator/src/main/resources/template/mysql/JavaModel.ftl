package ${model.packageName}.vo;


/**
* Created with IntelliJ IDEA.
* Description: ${model.comment}
* Author:      fengwenping
* Date:        ${.now}
*/
public class ${model.name!} {
    <#list model.fields as field>
    <#if field.name!='id'
    &&field.name!='createdBy'
    &&field.name!='createdDate'
    &&field.name!='lastModifiedBy'
    &&field.name!='lastModifiedDate'>
    /**
    * ${field.comment}
    */
    private ${StringHelper.subPrefix(field.javaType)!} ${field.name};
    </#if>
    </#list>
}
