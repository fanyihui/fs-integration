package com.fs.ie.model.valueset;

/**
 * Created by faen on 2018/2/6.
 */
public enum GenderCode {
    M("M"), F("F"), U("U"), O("O");

    private String gender;

    // 定义一个带参数的构造器，枚举类的构造器只能使用 private 修饰
    private GenderCode(String gender) {
        this.gender = gender;
    }

    // 定义 get set 方法
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
