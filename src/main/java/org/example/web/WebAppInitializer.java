package org.example.web;

import org.example.web.config.AppContextConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(AppContextConfig.class);

        servletContext.addListener(new ContextLoaderListener(applicationContext));

        XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext();
        webApplicationContext.setConfigLocation("classpath:web-config.xml");

        DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
