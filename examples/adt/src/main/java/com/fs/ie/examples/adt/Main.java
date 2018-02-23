package com.fs.ie.examples.adt;

import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Structure;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.util.Terser;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception{
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");

        /*Message message = new DefaultModelClassFactory().getMessageClass("ADT_A01", "2.3", false).newInstance();

        Terser terser = new Terser(message);

        terser.set("MSH-1-1","|");

        terser.set("/PID-3", "1234567");
        terser.set("/PID-5-1", "John");
        terser.set("/PID-5-2", "Smith");*/
    }
}
