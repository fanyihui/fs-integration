package com.fs.ie.model.valueset;

/**
 * Created by faen on 2018/2/5.
 */
public enum EventTypeEnum {
    //the value assigned for each enum is come from IHE PCD profile.
    //IPEC - Infusion Pump Event Communication, PCD10
    //PCD03: Communicate Infusion Order, Point-of-Care Infusion Verification (PIV) Profile
    //PCD09: Implantable Device – Cardiac - Observation profile
    //PCD01: Communicate PCD data, DEC profile
    //PCD04: Report Alert, Actor AR, outbound
    //PCD05: Report Alert Status, Actor AR, Inbound
    PCD01("PCD01"), ALERT("PCD04"), PCD05("PCD05"), IPEC("IPEC"), PCD03("PCD03"), PCD09("PCD09");

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
