package com.fs.ie.model;

/**
 * Created by faen on 2018/2/5.
 */
public enum EventTypeEnum {
    //the value assigned for each enum is come from IHE PCD profile.
    //IPEC - Infusion Pump Event Communication
    //PCD03: Communicate Infusion Order
    //PCD09: Implantable Device – Cardiac
    //PCD01: Communicate PCD data
    PCDDATA("PCD01"), ALERT("PCD04"), IPEC("IPEC"), CIO("PCD03"), PCD09("PCD09");

    // 定义一个 private 修饰的实例变量
    private String eventType;

    // 定义一个带参数的构造器，枚举类的构造器只能使用 private 修饰
    private EventTypeEnum(String eventType) {
        this.eventType = eventType;
    }

    // 定义 get set 方法
    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}
