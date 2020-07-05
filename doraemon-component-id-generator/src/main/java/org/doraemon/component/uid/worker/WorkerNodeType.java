package org.doraemon.component.uid.worker;

import org.doraemon.framework.base.IEnumProvider;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2020-07-05 17:48
 */
public enum WorkerNodeType implements IEnumProvider<Integer> {
    CONTAINER(1, "CONTAINER"),
    ACTUAL(2, "ACTUAL");;

    private Integer code;
    private String name;

    WorkerNodeType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }


    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
