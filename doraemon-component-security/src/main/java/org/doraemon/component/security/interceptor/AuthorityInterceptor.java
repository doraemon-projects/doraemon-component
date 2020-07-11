package org.doraemon.component.security.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.doraemon.component.security.service.AuthorityService;
import org.doraemon.framework.annotation.AuthOperation;
import org.doraemon.framework.annotation.AuthResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2019/1/12 15:51
 */
@Aspect
@Named("authorityInterceptor")
public class AuthorityInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorityInterceptor.class);

    @Inject
    @Named("authorityServiceImpl")
    private AuthorityService authorityService;

    @Pointcut("@annotation(org.doraemon.framework.annotation.AuthOperation)")
    public void authPointCut() {

    }

    @Before("authPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        LOGGER.info("begin check permission");
        final Class<?> aClass = joinPoint.getTarget().getClass();
        final AuthResource authResource = aClass.getAnnotation(AuthResource.class);
        if (authResource != null) {
            final MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            final AuthOperation authOperation = signature.getMethod().getAnnotation(AuthOperation.class);
            if (authOperation != null) {
                authorityService.checkPermission(authResource.code(), authOperation.code());
            }
        }
    }
}
