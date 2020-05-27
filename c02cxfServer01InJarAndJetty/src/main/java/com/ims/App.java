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

        //  cxf服务工厂
        JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
        //  设置服务暴露地址
        factoryBean.setAddress("http://192.168.1.3/service/helloService");
        //  设置暴露服务接口
        factoryBean.setServiceClass(HelloService.class);
        //  设置暴露服务实现类
        factoryBean.setServiceBean(new HelloServiceImpl());
        // 内置in拦截器 日志拦截器
        factoryBean.getInInterceptors().add(new LoggingInInterceptor());
        // 内置out拦截器 日志拦截器
        factoryBean.getOutInterceptors().add(new LoggingOutInterceptor());
        //自定义拦截器
        factoryBean.getInInterceptors().add(new GetHeaderInterceptor());
        //cxf服务开放工厂开放服务
        factoryBean.create();

        System.out.println("web webService started");
    }
}
