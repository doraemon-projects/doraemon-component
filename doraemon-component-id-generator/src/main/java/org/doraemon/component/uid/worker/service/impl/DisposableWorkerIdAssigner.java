package org.doraemon.component.uid.worker.service.impl;

import org.apache.commons.lang3.RandomUtils;
import org.doraemon.component.uid.worker.WorkerNodeType;
import org.doraemon.component.uid.worker.bean.WorkerNode;
import org.doraemon.component.uid.worker.dao.WorkerNodeDao;
import org.doraemon.component.uid.worker.service.WorkerIdAssigner;
import org.doraemon.framework.base.dao.BaseDao;
import org.doraemon.framework.base.service.impl.BaseServiceImpl;
import org.doraemon.framework.util.DockerUtils;
import org.doraemon.framework.util.NetUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2020-07-05 17:53
 */
@Named("disposableWorkerIdAssigner")
public class DisposableWorkerIdAssigner extends BaseServiceImpl<WorkerNode, Long> implements WorkerIdAssigner {

    private static final Logger LOGGER = LoggerFactory.getLogger(DisposableWorkerIdAssigner.class);

    @Inject
    private WorkerNodeDao workerNodeDao;

    @Override
    protected BaseDao<WorkerNode, Long> getDao() {
        return this.workerNodeDao;
    }

    @Override
    public long assignWorkerId() {
        final WorkerNode workerNode = this.buildWorkerNode();
        workerNode.setCreatedBy("system");
        workerNode.setCreatedDate(new Date());
        workerNode.setLastModifiedBy("system");
        workerNode.setLastModifiedDate(new Date());
        final WorkerNode node = this.insertSelective(workerNode);
        LOGGER.info("Add worker node: {}", node);
        return node.getId();
    }

    private WorkerNode buildWorkerNode() {
        WorkerNode workerNodeEntity = new WorkerNode();
        if (DockerUtils.isDocker()) {
            workerNodeEntity.setType(WorkerNodeType.CONTAINER.getCode());
            workerNodeEntity.setHostName(DockerUtils.getDockerHost());
            workerNodeEntity.setPort(DockerUtils.getDockerPort());
        } else {
            workerNodeEntity.setType(WorkerNodeType.ACTUAL.getCode());
            workerNodeEntity.setHostName(NetUtils.getLocalAddress());
            workerNodeEntity.setPort(System.currentTimeMillis() + "-" + RandomUtils.nextInt(0, 100000));
        }
        return workerNodeEntity;
    }
}
