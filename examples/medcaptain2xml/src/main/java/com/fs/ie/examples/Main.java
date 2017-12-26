package com.fs.ie.examples;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args){
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("META-INF.spring/camel-context.xml");
    }
}
