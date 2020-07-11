package org.doraemon.component.security.service.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.doraemon.component.security.service.AuthorityFinder;
import org.doraemon.component.security.vo.AuthorityOperationVO;
import org.doraemon.component.security.vo.AuthorityResourceVO;
import org.doraemon.framework.annotation.AuthOperation;
import org.doraemon.framework.annotation.AuthResource;
import org.doraemon.framework.util.ArrayUtils;
import org.doraemon.framework.util.ScanUtils;

import javax.inject.Named;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2019/1/12 16:02
 */
@Named("defaultAuthorityFinderImpl")
public class DefaultAuthorityFinderImpl implements AuthorityFinder {

    @Override
    public List<AuthorityResourceVO> findAuthorityResources() {
        List<AuthorityResourceVO> authorityResourceVOS = new ArrayList<>();
        final List<Class<?>> classes = ScanUtils.getClasses(this.getScanPackageName());
        if (CollectionUtils.isNotEmpty(classes)) {
            classes.forEach(aClass -> {
                final AuthorityResourceVO authorityResourceVO = this.buildAuthorityResource(aClass);
                if (authorityResourceVO != null) {
                    authorityResourceVOS.add(authorityResourceVO);
                }
            });
        }
        return Collections.emptyList();
    }

    private AuthorityResourceVO buildAuthorityResource(Class<?> authorityResourceClass) {
        final AuthResource authResource = authorityResourceClass.getAnnotation(AuthResource.class);
        if (authResource != null) {
            final Method[] methods = authorityResourceClass.getDeclaredMethods();
            if (!ArrayUtils.isEmpty(methods)) {
                AuthorityResourceVO authorityResourceVO = new AuthorityResourceVO();
                authorityResourceVO.setCode(authResource.code());
                authorityResourceVO.setDesc(authResource.desc());
                Arrays.stream(methods).map(method -> method.getAnnotation(AuthOperation.class)).filter(Objects::nonNull).forEach(authOperation -> {
                    if (authorityResourceVO.getAuthorityOperations() == null) {
                        authorityResourceVO.setAuthorityOperations(new ArrayList<>());
                    }
                    AuthorityOperationVO authorityOperationVO = new AuthorityOperationVO();
                    authorityOperationVO.setCode(authOperation.code());
                    authorityOperationVO.setDesc(authOperation.desc());
                    authorityOperationVO.setAuthorityResources(authorityResourceVO);
                    authorityResourceVO.getAuthorityOperations().add(authorityOperationVO);
                });
                return authorityResourceVO;
            }
        }
        return null;
    }

    @Override
    public String getScanPackageName() {
        return System.getProperty("authority.scanPackageName", "org.doraemon");
    }
}
