package com.base.library.bean;


import com.base.library.app.BaseApp;
import com.base.library.utils.PackageUtils;

/**
 * Created by yg on 2018/12/12.
 */

public class GetConfigRequest {
    private String robotId;
    private String channelId;
    private String parkId;
    private String monitorServerIp; //监控中心IP
    public String v = PackageUtils.getVersionName(BaseApp.getInstance());//版本名
    public String device = "android";//设备类型
    public String ttid = "1";

    public String getRobotId() {
        return robotId;
    }

    public void setRobotId(String robotId) {
        this.robotId = robotId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }

    public String getMonitorServerIp() {
        return monitorServerIp;
    }

    public void setMonitorServerIp(String monitorServerIp) {
        this.monitorServerIp = monitorServerIp;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getTtid() {
        return ttid;
    }

    public void setTtid(String ttid) {
        this.ttid = ttid;
    }
}
