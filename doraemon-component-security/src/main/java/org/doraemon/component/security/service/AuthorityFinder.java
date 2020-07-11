package org.doraemon.component.security.service;


import org.doraemon.component.security.vo.AuthorityResourceVO;

import java.util.List;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2019/1/11 11:52
 */
public interface AuthorityFinder {

    /**
     * 获取指定包路径下的权限资源
     *
     * @return
     */
    List<AuthorityResourceVO> findAuthorityResources();

    /**
     * 获取扫描的包路径
     *
     * @return
     */
    String getScanPackageName();
}
