package com.java1234;

import com.java1234.webservice.HelloWorldService;
import com.java1234.webservice.impl.HelloWorldServiceImplService;
import org.apache.cxf.frontend.ClientProxy;

/**
 * @author gaoxu
 * @date 2019-08-12 14:37
 * @description ... 类
 */
public class App {
    public static void main(String[] args) {
        HelloWorldServiceImplService service = new HelloWorldServiceImplService();
        HelloWorldService helloWorldService = service.getHelloWorldServiceImplPort();

        /*
            添加拦截器，内置的日志拦截器和自定义拦截器
         */
        /*
        org.apache.cxf.endpoint.Client client = ClientProxy.getClient(helloWorldService);
        client.getInInterceptors().add(new LoggingInInterceptor()); // 添加In拦截器 日志拦截器
        client.getOutInterceptors().add(new LoggingOutInterceptor()); // 添加Out拦截器 日志拦截器*/

        /*client.getOutInterceptors().add(new AddHeaderInterceptor("java1234", "123456")); // 添加自定义拦截器*/

        //调用服务
        System.out.println(helloWorldService.say("java1234_小锋"));

        /*
            调用返回数据类型是List<javabean>的方法
         */
       /*
        User user=new User();
        user.setId(1);
        user.setUserName("jack");
        user.setPassword("123456");
        List<Role> roleList=helloWorld.getRoleByUser(user);
        for(Role role:roleList){
            System.out.println(role.getId()+","+role.getRoleName());
        }*/

       /*
            调用返回数据类型是List<javabean>的方法
         */
       /*
        RoleMapArray arry = helloWorld.getRoles();

        List<RoleMap> roleList = arry.getItem();
        for (int i = 0; i < roleList.size(); i++) {
            RoleMap my = roleList.get(i);
            System.out.print(my.getKey() + ":");
            for (Role r : my.getValue()) {
                System.out.print(r.getId() + "," + r.getRoleName());
            }
            System.out.println("============");
        }*/
    }
}
