package org.doraemon.component.uid;

import org.doraemon.framework.exception.ApplicationException;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2020-07-05 17:36
 */
public interface UidGenerator {

    long getUID() throws ApplicationException;

    String parseUID(long uid) throws ApplicationException;
}
