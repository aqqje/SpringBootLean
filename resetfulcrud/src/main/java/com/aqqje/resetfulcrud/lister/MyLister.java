package com.aqqje.resetfulcrud.lister;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyLister implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("contextInitialized.....start");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("contextDestroyed...destroy");
    }
}
