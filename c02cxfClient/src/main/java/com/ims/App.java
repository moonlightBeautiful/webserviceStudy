package com.ims;

import com.ims.webService.HelloService;
import com.ims.webService.HelloServiceService;
import com.ims.webService.Role;
import com.ims.webService.User;
import com.ims.webServiceInterceptor.AddHeaderInterceptor;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        HelloServiceService helloServiceService = new HelloServiceService();
        HelloService helloService = helloServiceService.getHelloServicePort();
        Client client = ClientProxy.getClient(helloService);

        // 内置in拦截器 日志拦截器
        client.getInInterceptors().add(new LoggingInInterceptor());
        // 内置out拦截器 日志拦截器
        client.getOutInterceptors().add(new LoggingOutInterceptor());
        //自定义拦截器
        client.getOutInterceptors().add(new AddHeaderInterceptor("java1234", "123456"));

        System.out.println(helloService.say("大爷"));
        User user = new User();
        user.setUserName("zhangSan");
        user.setPassword("123456");
        List<Role> roleList = helloService.getRoleByUser(user);
        for (Role role : roleList) {
            System.out.println(role.getId() + "," + role.getRoleName());
        }
    }
}
