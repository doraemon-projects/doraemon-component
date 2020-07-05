package org.doraemon.component.uid.worker.bean;

import org.doraemon.framework.base.BaseObject;

import java.util.Date;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2020-07-05 17:55
 */
public class WorkerNode extends BaseObject<Long> {

    private String hostName;

    private String port;

    private int type;

    private Date launchDate = new Date();

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    @Override
    public String toString() {
        return "WorkerNode{" +
                "hostName='" + hostName + '\'' +
                ", port='" + port + '\'' +
                ", type=" + type +
                ", launchDate=" + launchDate +
                '}';
    }
}
