package org.doraemon.component.mybatis.util;

import org.doraemon.component.mybatis.enums.DatabaseType;
import org.doraemon.component.mybatis.enums.MysqlDataType;
import org.doraemon.component.mybatis.enums.OracleDataType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: fengwenping
 * Description:
 * Date: 2018-10-26
 * Time: 下午8:28
 */
public final class SqlHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(SqlHelper.class);

    public static String getJavaType(DatabaseType databaseType, String jdbcType) {
        LOGGER.debug("databaseType: {}, jdbcType: {}", databaseType.getCode(), jdbcType);
        switch (databaseType) {
            case ORACLE:
                return OracleDataType.fromString(jdbcType).getName();
            default:
                return MysqlDataType.fromString(jdbcType).getName();
        }
    }

}
