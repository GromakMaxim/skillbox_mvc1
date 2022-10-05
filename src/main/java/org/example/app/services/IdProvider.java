package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class IdProvider implements InitializingBean, DisposableBean, BeanPostProcessor {
    Logger logger = Logger.getLogger(this.getClass());

    public int provideId(Book book) {
        return book.getId();
    }

    private void initIdProvider() {
        logger.info("provider init");
    }

    private void destroyIdProvider() {
        logger.info("provider destroy");
    }

    private void defaultInit(){
        logger.info("default init");
    }

    private void defaultDestroy(){
        logger.info("default destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
