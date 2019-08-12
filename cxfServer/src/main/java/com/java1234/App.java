package com.java1234;

import com.java1234.webservice.HelloWorldService;
import com.java1234.webservice.impl.HelloWorldServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("web service start");
        //暴露接口的类
        HelloWorldService helloWorldService = new HelloWorldServiceImpl();
        //暴露接口的ip地址
        String address = "http://10.0.102.142/helloWorld";
        //开始暴露webservice接口（需要jdk支持）
        Endpoint.publish(address, helloWorldService);
        /*JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
        factoryBean.setAddress(address); // 设置暴露地址
        factoryBean.setServiceClass(HelloWorldService.class); // 接口类
        factoryBean.setServiceBean(implementor); // 设置实现类
        factoryBean.getInInterceptors().add(new LoggingInInterceptor()); // 添加in拦截器 日志拦截器
        factoryBean.getOutInterceptors().add(new LoggingOutInterceptor()); // 添加out拦截器 日志拦截器

        factoryBean.getInInterceptors().add(new MyInterceptor());

        factoryBean.create(); // 创建webservice接口*/
        System.out.println("web service started");
    }
}
