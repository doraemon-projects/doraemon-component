package org.doraemon.component.security.service.impl;

import jdk.jfr.Name;
import org.doraemon.component.security.service.AuthorityService;
import org.doraemon.framework.exception.ApplicationRuntimeException;
import org.doraemon.framework.response.ResultCode;
import org.doraemon.framework.util.AssertUtils;
import org.doraemon.framework.util.ExceptionUtils;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2019/1/12 16:37
 */
@Name("authorityServiceImpl")
public class AuthorityServiceImpl implements AuthorityService {
    @Override
    public void checkPermission(String authResourceCode, String authOperationCode) {
        AssertUtils.assertNotNull(authResourceCode, "authority resource code must can not be null.");
        AssertUtils.assertNotNull(authOperationCode, "authority operation code must can not be null.");
        ExceptionUtils.throwNewException(ResultCode.AUTH_CHECK_ERROR.getCode());
        throw new ApplicationRuntimeException(ResultCode.AUTH_CHECK_ERROR.getCode(), ResultCode.AUTH_CHECK_ERROR.getName());
    }
}
