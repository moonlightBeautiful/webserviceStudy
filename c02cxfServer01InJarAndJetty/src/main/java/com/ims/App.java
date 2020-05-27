package com.ims;

import com.ims.webService.HelloService;
import com.ims.webService.impl.HelloServiceImpl;
import com.ims.webServiceInterceptor.GetHeaderInterceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("web webService start");

        HelloService helloService = new HelloServiceImpl(); //暴露服务
        String address = "http://192.168.1.33/service/helloService"; //暴露接口的ip地址
        JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean(); //cxf服务开放工厂
        factoryBean.setAddress(address); // 设置暴露地址
        factoryBean.setServiceClass(HelloService.class); // 接口类
        factoryBean.setServiceBean(helloService); // 设置实现类
        factoryBean.getInInterceptors().add(new LoggingInInterceptor()); // 内置in拦截器 日志拦截器
        factoryBean.getOutInterceptors().add(new LoggingOutInterceptor()); // 内置out拦截器 日志拦截器
        factoryBean.getInInterceptors().add(new GetHeaderInterceptor());  //自定义拦截器
        factoryBean.create(); //cxf服务开放工厂开放服务


        System.out.println("web webService started");
    }
}
