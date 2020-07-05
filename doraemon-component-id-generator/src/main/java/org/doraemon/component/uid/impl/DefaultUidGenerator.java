package org.doraemon.component.uid.impl;

import org.doraemon.component.uid.UidGenerator;
import org.doraemon.component.uid.worker.service.WorkerIdAssigner;
import org.doraemon.framework.exception.ApplicationException;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2020-07-05 17:37
 */
@Named("defaultUidGenerator")
public class DefaultUidGenerator implements UidGenerator {

    @Inject
    @Named("disposableWorkerIdAssigner")
    private WorkerIdAssigner workerIdAssigner;

    @Override
    public long getUID() throws ApplicationException {
        return workerIdAssigner.assignWorkerId();
    }
}
