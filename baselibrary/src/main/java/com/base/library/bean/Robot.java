package com.base.library.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yg on 2018/12/12.
 */

public class Robot {
    private Integer parkId;
    private String robotId;
    private String recognizerIp;
    private String strictAllowPass;

    private String cloudIp;//String	否	云服务IP
    private String nativeIp;//String	否	本机IP
    private String subnetmaskIp;//String	否	子网掩码IP
    private String gatewayIp;//String	否	网关IP
    private String mac;//String	否	Mac地址
    private String channelId;//String	否	通道Id
    private String recognizerPort;//String	否	控制器端口
    private String controllerIp;//String	否	控制器IP
    private String panoramaIp;//String	否	全景相机ip
    private String panoramaPort;//String	否	全景相机端口
    private String wechatUrl;//String	否	微信支付二维码url串
    private String alipayUrl;//String	否	支付宝支付二维码url串
    private String sentryBoxId;//String	否	岗亭Id
    private String sentryBoxIp;//String	否	岗亭IP,带端口。如：127.0.0.1:8980
    private String accessType;//String	否	出入类型：1:标准进 2:标准出 3:单通道
    private String channelType;//String	否	通道类型： 1:大车场通道 2:小车场通道
    private String parkAreaId;//String	否	车场区域id
    private String updateTime;//String	否	全景相机端口
    private String token;//String	否	全景相机端口
    private String privateKey;//String	否	全景相机端口
    private String voiceBeginTime1;//String	否	第一时间段开始时间
    private String voiceEndTime1;//String	否	第一时间段结束时间
    private String voiceVolume1;//String	否	第一时间段音量
    private String voiceBeginTime2;//String	否	第二时间段开始时间
    private String voiceEndTime2;//String	否	第二时间段结束时间
    private String voiceVolume2;//String	否	第二时间段音量
    private String displayContent;//String	否	屏幕显示
    private String twoRecognitionIp;//String	否	二次识别相机ip
    private String addressMac;//String	否	通道机器人mac地址
    private String monthStartTime;//String	否	月租车有效开始时间
    private String monthStopTime;//String	否	月租车标语有效结束时间
    private String monthPrompt;//String	否	月租车提示语
    private String tempStartTime;//String	否	临时车有效开始时间
    private String tempStopTime;//String	否	临时车有效结束时间
    private String tempPrompt;//String	否	临时车提示语
    private String monitorServerIp;//String	否	监控服务器IP
    private String monitorServerPort;//String	否	监控服务器可视对讲端口

    //通道列表里面的通道配置
    private String isPanorama;//String	否	是否开启全景相机 0不开启 1开启
    private String secondIdentifyCamera;
    private String channelName = "channel";
    private String invoiceMachine;//	Integer	Shi	发票机 0 无  1 有
    private String haveDisplay;
    private String callMode;//	Integer	否	1 轮呼模式 2 全呼模式
    private String moneyMachine;//	Integer	是	投币机 0 无   1 有
    private String printeMachine;//	Integer	是	打印机 0 无  1 有
    private String isTwoRecognition;//String	否	是否开启二次识别 0不开启 1开启
    private String allowPassTimeBegin;//"": "01:00:00",
    private String allowPassTimeEnd;//     "": "03:00:00"

    private String strictConfirmPrompt;//	String	否	严进确认界面提示语
    private String strictConfirmStartTime;//	String	否	严进确认提示语生效开始时间
    private String strictConfirmStopTime;//	String	否	严进确认提示语生效结束时间
    private String tempNorightPrompt;//String	否	临时车无通道权限界面提示语
    private String tempNorightStartTime;//String	否	临时车无通道权限提示语生效开始时间
    private String tempNorightStopTime;//	String	否	临时车无通道权限提示语生效结束时间

    private String hostedMode;//0:自动托管 1:手动托管 2:关闭托管

    public String getAllowPassTimeBegin() {
        return allowPassTimeBegin;
    }

    public void setAllowPassTimeBegin(String allowPassTimeBegin) {
        this.allowPassTimeBegin = allowPassTimeBegin;
    }

    public String getAllowPassTimeEnd() {
        return allowPassTimeEnd;
    }

    public void setAllowPassTimeEnd(String allowPassTimeEnd) {
        this.allowPassTimeEnd = allowPassTimeEnd;
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    public String getRobotId() {
        return robotId;
    }

    public void setRobotId(String robotId) {
        this.robotId = robotId;
    }

    public String getCloudIp() {
        return cloudIp;
    }

    public void setCloudIp(String cloudIp) {
        this.cloudIp = cloudIp;
    }

    public String getNativeIp() {
        return nativeIp;
    }

    public void setNativeIp(String nativeIp) {
        this.nativeIp = nativeIp;
    }

    public String getSubnetmaskIp() {
        return subnetmaskIp;
    }

    public void setSubnetmaskIp(String subnetmaskIp) {
        this.subnetmaskIp = subnetmaskIp;
    }

    public String getGatewayIp() {
        return gatewayIp;
    }

    public void setGatewayIp(String gatewayIp) {
        this.gatewayIp = gatewayIp;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getMonitorServerIp() {
        return monitorServerIp;
    }

    public void setMonitorServerIp(String monitorServerIp) {
        this.monitorServerIp = monitorServerIp;
    }

    public String getMonitorServerPort() {
        return monitorServerPort;
    }

    public void setMonitorServerPort(String monitorServerPort) {
        this.monitorServerPort = monitorServerPort;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getControllerIp() {
        return controllerIp;
    }

    public void setControllerIp(String controllerIp) {
        this.controllerIp = controllerIp;
    }

    public String getRecognizerIp() {
        return recognizerIp;
    }

    public void setRecognizerIp(String recognizerIp) {
        this.recognizerIp = recognizerIp;
    }

    public String getRecognizerPort() {
        return recognizerPort;
    }

    public void setRecognizerPort(String recognizerPort) {
        this.recognizerPort = recognizerPort;
    }

    public String getTwoRecognitionIp() {
        return twoRecognitionIp;
    }

    public void setTwoRecognitionIp(String twoRecognitionIp) {
        this.twoRecognitionIp = twoRecognitionIp;
    }

    public String getWechatUrl() {
        return wechatUrl;
    }

    public void setWechatUrl(String wechatUrl) {
        this.wechatUrl = wechatUrl;
    }

    public String getAlipayUrl() {
        return alipayUrl;
    }

    public void setAlipayUrl(String alipayUrl) {
        this.alipayUrl = alipayUrl;
    }

    public String getSentryBoxId() {
        return sentryBoxId;
    }

    public void setSentryBoxId(String sentryBoxId) {
        this.sentryBoxId = sentryBoxId;
    }

    public String getSentryBoxIp() {
        return sentryBoxIp;
    }

    public void setSentryBoxIp(String sentryBoxIp) {
        this.sentryBoxIp = sentryBoxIp;
    }

    public String getParkAreaId() {
        return parkAreaId;
    }

    public void setParkAreaId(String parkAreaId) {
        this.parkAreaId = parkAreaId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getVoiceBeginTime1() {
        return voiceBeginTime1;
    }

    public void setVoiceBeginTime1(String voiceBeginTime1) {
        this.voiceBeginTime1 = voiceBeginTime1;
    }

    public String getVoiceEndTime1() {
        return voiceEndTime1;
    }

    public void setVoiceEndTime1(String voiceEndTime1) {
        this.voiceEndTime1 = voiceEndTime1;
    }

    public String getVoiceVolume1() {
        return voiceVolume1;
    }

    public void setVoiceVolume1(String voiceVolume1) {
        this.voiceVolume1 = voiceVolume1;
    }

    public String getVoiceBeginTime2() {
        return voiceBeginTime2;
    }

    public void setVoiceBeginTime2(String voiceBeginTime2) {
        this.voiceBeginTime2 = voiceBeginTime2;
    }

    public String getVoiceEndTime2() {
        return voiceEndTime2;
    }

    public void setVoiceEndTime2(String voiceEndTime2) {
        this.voiceEndTime2 = voiceEndTime2;
    }

    public String getVoiceVolume2() {
        return voiceVolume2;
    }

    public void setVoiceVolume2(String voiceVolume2) {
        this.voiceVolume2 = voiceVolume2;
    }

    public String getDisplayContent() {
        return displayContent;
    }

    public void setDisplayContent(String displayContent) {
        this.displayContent = displayContent;
    }

    public String getStrictAllowPass() {
        return strictAllowPass;
    }

    public void setStrictAllowPass(String strictAllowPass) {
        this.strictAllowPass = strictAllowPass;
    }

    public String getSecondIdentifyCamera() {
        return secondIdentifyCamera;
    }

    public void setSecondIdentifyCamera(String secondIdentifyCamera) {
        this.secondIdentifyCamera = secondIdentifyCamera;
    }

    public String getMonthStartTime() {
        return monthStartTime;
    }

    public void setMonthStartTime(String monthStartTime) {
        this.monthStartTime = monthStartTime;
    }

    public String getMonthStopTime() {
        return monthStopTime;
    }

    public void setMonthStopTime(String monthStopTime) {
        this.monthStopTime = monthStopTime;
    }

    public String getMonthPrompt() {
        return monthPrompt;
    }

    public void setMonthPrompt(String monthPrompt) {
        this.monthPrompt = monthPrompt;
    }

    public String getTempStartTime() {
        return tempStartTime;
    }

    public void setTempStartTime(String tempStartTime) {
        this.tempStartTime = tempStartTime;
    }

    public String getTempStopTime() {
        return tempStopTime;
    }

    public void setTempStopTime(String tempStopTime) {
        this.tempStopTime = tempStopTime;
    }

    public String getTempPrompt() {
        return tempPrompt;
    }

    public void setTempPrompt(String tempPrompt) {
        this.tempPrompt = tempPrompt;
    }

    public String getInvoiceMachine() {
        return invoiceMachine;
    }

    public void setInvoiceMachine(String invoiceMachine) {
        this.invoiceMachine = invoiceMachine;
    }

    public String getHaveDisplay() {
        return haveDisplay;
    }

    public void setHaveDisplay(String haveDisplay) {
        this.haveDisplay = haveDisplay;
    }

    public String getCallMode() {
        return callMode;
    }

    public void setCallMode(String callMode) {
        this.callMode = callMode;
    }


    public String getPrinteMachine() {
        return printeMachine;
    }

    public void setPrinteMachine(String printeMachine) {
        this.printeMachine = printeMachine;
    }

    public String getMoneyMachine() {
        return moneyMachine;
    }

    public void setMoneyMachine(String moneyMachine) {
        this.moneyMachine = moneyMachine;
    }

    public String getIsPanorama() {
        return isPanorama;
    }

    public void setIsPanorama(String isPanorama) {
        this.isPanorama = isPanorama;
    }

    public String getPanoramaIp() {
        return panoramaIp;
    }

    public void setPanoramaIp(String panoramaIp) {
        this.panoramaIp = panoramaIp;
    }

    public String getIsTwoRecognition() {
        return isTwoRecognition;
    }

    public void setIsTwoRecognition(String isTwoRecognition) {
        this.isTwoRecognition = isTwoRecognition;
    }

    public String getStrictConfirmPrompt() {
        return strictConfirmPrompt;
    }

    public void setStrictConfirmPrompt(String strictConfirmPrompt) {
        this.strictConfirmPrompt = strictConfirmPrompt;
    }

    public String getStrictConfirmStartTime() {
        return strictConfirmStartTime;
    }

    public void setStrictConfirmStartTime(String strictConfirmStartTime) {
        this.strictConfirmStartTime = strictConfirmStartTime;
    }

    public String getStrictConfirmStopTime() {
        return strictConfirmStopTime;
    }

    public void setStrictConfirmStopTime(String strictConfirmStopTime) {
        this.strictConfirmStopTime = strictConfirmStopTime;
    }

    public String getTempNorightPrompt() {
        return tempNorightPrompt;
    }

    public void setTempNorightPrompt(String tempNorightPrompt) {
        this.tempNorightPrompt = tempNorightPrompt;
    }

    public String getTempNorightStartTime() {
        return tempNorightStartTime;
    }

    public void setTempNorightStartTime(String tempNorightStartTime) {
        this.tempNorightStartTime = tempNorightStartTime;
    }

    public String getTempNorightStopTime() {
        return tempNorightStopTime;
    }

    public void setTempNorightStopTime(String tempNorightStopTime) {
        this.tempNorightStopTime = tempNorightStopTime;
    }

    public String getHostedMode() {
        return hostedMode;
    }

    public void setHostedMode(String hostedMode) {
        this.hostedMode = hostedMode;
    }


    private List<ChannelListBean> channelList;

    public List<ChannelListBean> getChannelList() {
        return channelList;
    }

    public static class ChannelListBean implements Serializable {

        private String channelName = "channel";
        private String recognizerIp;
        private String channelId = "-1";//String	否	通道Id
        private String recognizerPort;//String	否	控制器端口
        private String controllerIp;//String	否	控制器IP
        private String panoramaIp;//String	否	全景相机ip
        private String wechatUrl;//String	否	微信支付二维码url串
        private String alipayUrl;//String	否	支付宝支付二维码url串
        private String sentryBoxId;//String	否	岗亭Id
        private String sentryBoxIp;//String	否	岗亭IP,带端口。如：127.0.0.1:8980
        private String accessType;//String	否	出入类型：1:标准进 2:标准出 3:单通道
        private String channelType;//String	否	通道类型： 1:大车场通道 2:小车场通道
        private String voiceBeginTime1;//String	否	第一时间段开始时间
        private String voiceEndTime1;//String	否	第一时间段结束时间
        private String voiceVolume1;//String	否	第一时间段音量
        private String voiceBeginTime2;//String	否	第二时间段开始时间
        private String voiceEndTime2;//String	否	第二时间段结束时间
        private String voiceVolume2;//String	否	第二时间段音量
        private String displayContent;//String	否	屏幕显示
        private String twoRecognitionIp;//String	否	二次识别相机ip
        private String isPanorama;//String	否	是否开启全景相机 0不开启 1开启
        private String isTwoRecognition;//String	否	是否开启二次识别 0不开启 1开启
        private String addressMac;//String	否	通道机器人mac地址
        private String monitorServerIp;//String	否	监控服务器IP
        private String monitorServerPort;//String	否	监控服务器可视对讲端口
        private String secondIdentifyCamera;
        private String invoiceMachine;//	Integer	Shi	发票机 0 无  1 有
        private String haveDisplay;
        private String callMode;//	Integer	1 轮呼模式 2 全呼模式
        private String printeMachine;//	Integer	是	打印机 0 无  1 有
        private String moneyMachine;//	Integer	是	投币机 0 无   1 有

        private String allowPassTimeBegin;//"": "01:00:00",
        private String allowPassTimeEnd;//     "": "03:00:00"

        public String getAllowPassTimeBegin() {
            return allowPassTimeBegin;
        }

        public void setAllowPassTimeBegin(String allowPassTimeBegin) {
            this.allowPassTimeBegin = allowPassTimeBegin;
        }

        public String getAllowPassTimeEnd() {
            return allowPassTimeEnd;
        }

        public void setAllowPassTimeEnd(String allowPassTimeEnd) {
            this.allowPassTimeEnd = allowPassTimeEnd;
        }

        public String getPrinteMachine() {
            return printeMachine;
        }

        public void setPrinteMachine(String printeMachine) {
            this.printeMachine = printeMachine;
        }

        public String getMoneyMachine() {
            return moneyMachine;
        }

        public void setMoneyMachine(String moneyMachine) {
            this.moneyMachine = moneyMachine;
        }

        public String getCallMode() {
            return callMode;
        }

        public void setCallMode(String callMode) {
            this.callMode = callMode;
        }

        public String getHaveDisplay() {
            return haveDisplay;
        }

        public void setHaveDisplay(String haveDisplay) {
            this.haveDisplay = haveDisplay;
        }

        public String getInvoiceMachine() {
            return invoiceMachine;
        }

        public void setInvoiceMachine(String invoiceMachine) {
            this.invoiceMachine = invoiceMachine;
        }

        public String getSecondIdentifyCamera() {
            return secondIdentifyCamera;
        }

        public void setSecondIdentifyCamera(String secondIdentifyCamera) {
            this.secondIdentifyCamera = secondIdentifyCamera;
        }

        public String getMonitorServerIp() {
            return monitorServerIp;
        }

        public void setMonitorServerIp(String monitorServerIp) {
            this.monitorServerIp = monitorServerIp;
        }

        public String getMonitorServerPort() {
            return monitorServerPort;
        }

        public void setMonitorServerPort(String monitorServerPort) {
            this.monitorServerPort = monitorServerPort;
        }

        public String getAccessType() {
            return accessType;
        }

        public void setAccessType(String accessType) {
            this.accessType = accessType;
        }

        public String getAlipayUrl() {
            return alipayUrl;
        }

        public void setAlipayUrl(String alipayUrl) {
            this.alipayUrl = alipayUrl;
        }

        public String getChannelId() {
            return channelId;
        }

        public void setChannelId(String channelId) {
            this.channelId = channelId;
        }

        public String getChannelName() {
            return channelName;
        }

        public void setChannelName(String channelName) {
            this.channelName = channelName;
        }

        public String getChannelType() {
            return channelType;
        }

        public void setChannelType(String channelType) {
            this.channelType = channelType;
        }

        public String getControllerIp() {
            return controllerIp;
        }

        public void setControllerIp(String controllerIp) {
            this.controllerIp = controllerIp;
        }

        public String getDisplayContent() {
            return displayContent;
        }

        public void setDisplayContent(String displayContent) {
            this.displayContent = displayContent;
        }

        public String getPanoramaIp() {
            return panoramaIp;
        }

        public void setPanoramaIp(String panoramaIp) {
            this.panoramaIp = panoramaIp;
        }

        public String getRecognizerIp() {
            return recognizerIp;
        }

        public void setRecognizerIp(String recognizerIp) {
            this.recognizerIp = recognizerIp;
        }

        public String getRecognizerPort() {
            return recognizerPort;
        }

        public void setRecognizerPort(String recognizerPort) {
            this.recognizerPort = recognizerPort;
        }

        public String getSentryBoxId() {
            return sentryBoxId;
        }

        public void setSentryBoxId(String sentryBoxId) {
            this.sentryBoxId = sentryBoxId;
        }

        public String getTwoRecognitionIp() {
            return twoRecognitionIp;
        }

        public void setTwoRecognitionIp(String twoRecognitionIp) {
            this.twoRecognitionIp = twoRecognitionIp;
        }

        public String getVoiceBeginTime1() {
            return voiceBeginTime1;
        }

        public void setVoiceBeginTime1(String voiceBeginTime1) {
            this.voiceBeginTime1 = voiceBeginTime1;
        }

        public String getVoiceBeginTime2() {
            return voiceBeginTime2;
        }

        public void setVoiceBeginTime2(String voiceBeginTime2) {
            this.voiceBeginTime2 = voiceBeginTime2;
        }

        public String getVoiceEndTime1() {
            return voiceEndTime1;
        }

        public void setVoiceEndTime1(String voiceEndTime1) {
            this.voiceEndTime1 = voiceEndTime1;
        }

        public String getVoiceEndTime2() {
            return voiceEndTime2;
        }

        public void setVoiceEndTime2(String voiceEndTime2) {
            this.voiceEndTime2 = voiceEndTime2;
        }

        public String getVoiceVolume1() {
            return voiceVolume1;
        }

        public void setVoiceVolume1(String voiceVolume1) {
            this.voiceVolume1 = voiceVolume1;
        }

        public String getVoiceVolume2() {
            return voiceVolume2;
        }

        public void setVoiceVolume2(String voiceVolume2) {
            this.voiceVolume2 = voiceVolume2;
        }

        public String getWechatUrl() {
            return wechatUrl;
        }

        public void setWechatUrl(String wechatUrl) {
            this.wechatUrl = wechatUrl;
        }

        public String getIsPanorama() {
            return isPanorama;
        }

        public void setIsPanorama(String isPanorama) {
            this.isPanorama = isPanorama;
        }

        public String getIsTwoRecognition() {
            return isTwoRecognition;
        }

        public void setIsTwoRecognition(String isTwoRecognition) {
            this.isTwoRecognition = isTwoRecognition;
        }

        public String getAddressMac() {
            return addressMac;
        }

        public void setAddressMac(String addressMac) {
            this.addressMac = addressMac;
        }

        public String getSentryBoxIp() {
            return sentryBoxIp;
        }

        public void setSentryBoxIp(String sentryBoxIp) {
            this.sentryBoxIp = sentryBoxIp;
        }

        @Override
        public String toString() {
            return "ChannelListBean{" +
                    "channelName='" + channelName + '\'' +
                    ", recognizerIp='" + recognizerIp + '\'' +
                    ", channelId='" + channelId + '\'' +
                    ", recognizerPort='" + recognizerPort + '\'' +
                    ", controllerIp='" + controllerIp + '\'' +
                    ", panoramaIp='" + panoramaIp + '\'' +
                    ", wechatUrl='" + wechatUrl + '\'' +
                    ", alipayUrl='" + alipayUrl + '\'' +
                    ", sentryBoxId='" + sentryBoxId + '\'' +
                    ", sentryBoxIp='" + sentryBoxIp + '\'' +
                    ", accessType='" + accessType + '\'' +
                    ", channelType='" + channelType + '\'' +
                    ", voiceBeginTime1='" + voiceBeginTime1 + '\'' +
                    ", voiceEndTime1='" + voiceEndTime1 + '\'' +
                    ", voiceVolume1='" + voiceVolume1 + '\'' +
                    ", voiceBeginTime2='" + voiceBeginTime2 + '\'' +
                    ", voiceEndTime2='" + voiceEndTime2 + '\'' +
                    ", voiceVolume2='" + voiceVolume2 + '\'' +
                    ", displayContent='" + displayContent + '\'' +
                    ", twoRecognitionIp='" + twoRecognitionIp + '\'' +
                    ", isPanorama='" + isPanorama + '\'' +
                    ", isTwoRecognition='" + isTwoRecognition + '\'' +
                    ", addressMac='" + addressMac + '\'' +
                    ", monitorServerIp='" + monitorServerIp + '\'' +
                    ", monitorServerPort='" + monitorServerPort + '\'' +
                    ", secondIdentifyCamera='" + secondIdentifyCamera + '\'' +
                    ", invoiceMachine='" + invoiceMachine + '\'' +
                    ", haveDisplay='" + haveDisplay + '\'' +
                    ", callMode='" + callMode + '\'' +
                    ", printeMachine='" + printeMachine + '\'' +
                    ", moneyMachine='" + moneyMachine + '\'' +
                    ", allowPassTimeBegin='" + allowPassTimeBegin + '\'' +
                    ", allowPassTimeEnd='" + allowPassTimeEnd + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Robot{" +
                "parkId=" + parkId +
                ", robotId='" + robotId + '\'' +
                ", recognizerIp='" + recognizerIp + '\'' +
                ", strictAllowPass='" + strictAllowPass + '\'' +
                ", cloudIp='" + cloudIp + '\'' +
                ", nativeIp='" + nativeIp + '\'' +
                ", subnetmaskIp='" + subnetmaskIp + '\'' +
                ", gatewayIp='" + gatewayIp + '\'' +
                ", mac='" + mac + '\'' +
                ", channelId='" + channelId + '\'' +
                ", recognizerPort='" + recognizerPort + '\'' +
                ", controllerIp='" + controllerIp + '\'' +
                ", panoramaIp='" + panoramaIp + '\'' +
                ", panoramaPort='" + panoramaPort + '\'' +
                ", wechatUrl='" + wechatUrl + '\'' +
                ", alipayUrl='" + alipayUrl + '\'' +
                ", sentryBoxId='" + sentryBoxId + '\'' +
                ", sentryBoxIp='" + sentryBoxIp + '\'' +
                ", accessType='" + accessType + '\'' +
                ", channelType='" + channelType + '\'' +
                ", parkAreaId='" + parkAreaId + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", token='" + token + '\'' +
                ", privateKey='" + privateKey + '\'' +
                ", voiceBeginTime1='" + voiceBeginTime1 + '\'' +
                ", voiceEndTime1='" + voiceEndTime1 + '\'' +
                ", voiceVolume1='" + voiceVolume1 + '\'' +
                ", voiceBeginTime2='" + voiceBeginTime2 + '\'' +
                ", voiceEndTime2='" + voiceEndTime2 + '\'' +
                ", voiceVolume2='" + voiceVolume2 + '\'' +
                ", displayContent='" + displayContent + '\'' +
                ", twoRecognitionIp='" + twoRecognitionIp + '\'' +
                ", addressMac='" + addressMac + '\'' +
                ", monthStartTime='" + monthStartTime + '\'' +
                ", monthStopTime='" + monthStopTime + '\'' +
                ", monthPrompt='" + monthPrompt + '\'' +
                ", tempStartTime='" + tempStartTime + '\'' +
                ", tempStopTime='" + tempStopTime + '\'' +
                ", tempPrompt='" + tempPrompt + '\'' +
                ", monitorServerIp='" + monitorServerIp + '\'' +
                ", monitorServerPort='" + monitorServerPort + '\'' +
                ", isPanorama='" + isPanorama + '\'' +
                ", secondIdentifyCamera='" + secondIdentifyCamera + '\'' +
                ", channelName='" + channelName + '\'' +
                ", invoiceMachine='" + invoiceMachine + '\'' +
                ", haveDisplay='" + haveDisplay + '\'' +
                ", callMode='" + callMode + '\'' +
                ", moneyMachine='" + moneyMachine + '\'' +
                ", printeMachine='" + printeMachine + '\'' +
                ", isTwoRecognition='" + isTwoRecognition + '\'' +
                ", allowPassTimeBegin='" + allowPassTimeBegin + '\'' +
                ", allowPassTimeEnd='" + allowPassTimeEnd + '\'' +
                ", strictConfirmPrompt='" + strictConfirmPrompt + '\'' +
                ", strictConfirmStartTime='" + strictConfirmStartTime + '\'' +
                ", strictConfirmStopTime='" + strictConfirmStopTime + '\'' +
                ", tempNorightPrompt='" + tempNorightPrompt + '\'' +
                ", tempNorightStartTime='" + tempNorightStartTime + '\'' +
                ", tempNorightStopTime='" + tempNorightStopTime + '\'' +
                ", hostedMode='" + hostedMode + '\'' +
                ", channelList=" + channelList +
                '}';
    }
}
