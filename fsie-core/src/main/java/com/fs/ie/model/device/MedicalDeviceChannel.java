package com.fs.ie.model.device;

public abstract class MedicalDeviceChannel {
    private String channelOperationStatus;
    private String physicalChannelNo;
    private String logicalChannelNo;

    public String getChannelOperationStatus() {
        return channelOperationStatus;
    }

    public void setChannelOperationStatus(String channelOperationStatus) {
        this.channelOperationStatus = channelOperationStatus;
    }

    public String getPhysicalChannelNo() {
        return physicalChannelNo;
    }

    public void setPhysicalChannelNo(String physicalChannelNo) {
        this.physicalChannelNo = physicalChannelNo;
    }

    public String getLogicalChannelNo() {
        return logicalChannelNo;
    }

    public void setLogicalChannelNo(String logicalChannelNo) {
        this.logicalChannelNo = logicalChannelNo;
    }
}
