JDK：依赖jdk1.6以上
服务端  
    1.service和impl类上+注解@WebService
    2.发布服务：
        HelloService helloService = new HelloServiceImpl();  //需要对外公开的服务类
        String address = "http://192.168.1.33/service/helloService"; //服务地址 本机ip
        Endpoint.publish(address, helloService); //开始暴露webservice接口
    3.测试是否发布成功
        浏览器wsdl地址：http://本机ip地址/service/helloService?wsdl
