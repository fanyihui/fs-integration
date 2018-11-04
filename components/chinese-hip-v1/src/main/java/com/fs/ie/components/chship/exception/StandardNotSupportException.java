package com.fs.ie.components.chship.exception;

public class StandardNotSupportException extends Exception{
    public StandardNotSupportException(String message){
        super("本互联互通标准不支持收到的'"+message+"'服务");
    }
}
