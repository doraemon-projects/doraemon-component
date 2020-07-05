package org.doraemon.component.uid.impl;

import org.doraemon.component.uid.UidGenerator;
import org.doraemon.framework.exception.ApplicationException;

import javax.inject.Named;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2020-07-05 17:38
 */
@Named("cachedUidGenerator")
public class CachedUidGenerator implements UidGenerator {
    @Override
    public long getUID() throws ApplicationException {
        return 0;
    }
}
