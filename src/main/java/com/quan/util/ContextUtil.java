package com.quan.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ContextUtil {
    private static ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");;
    private ContextUtil(){
    }
    public static ApplicationContext  getContext(){
        return context;
    }
}

