package com.base.library.bean;

/**
 * Created by yg on 2018/12/12.
 */

public class ParkInfo {
    private String parkNum;
    private String parkName;
    private String serverTime;
    private String areaId;

    private Boolean netstat; //连接外网的网络状态 true正常  false异常

    public Boolean isNetstat() {
        return netstat;
    }

    public void setNetstat(Boolean netstat) {
        this.netstat = netstat;
    }

    public String getAreaId() {
        return areaId;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }

    public String getParkNum() {
        return parkNum;
    }

    public void setParkNum(String parkNum) {
        this.parkNum = parkNum;
    }

    @Override
    public String toString() {
        return "ParkInfo{" +
                "parkNum='" + parkNum + '\'' +
                ", parkName='" + parkName + '\'' +
                ", serverTime='" + serverTime + '\'' +
                ", areaId='" + areaId + '\'' +
                ", netstat=" + netstat +
                '}';
    }
}
