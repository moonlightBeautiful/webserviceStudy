JDK：依赖jdk1.6以上
    服务端  
        1.service和impl类上+注解@WebService
        2.发布服务：
            HelloService helloService = new HelloServiceImpl();  //需要对外公开的服务类
            String address = "http://192.168.1.33/service/helloService"; //服务地址 本机ip
            Endpoint.publish(address, helloService); //开始暴露webservice接口
        3.wsdl地址：http://192.168.1.33/service/helloService?wsdl
    客户端
        1.使用JDK自带的工具wsimport解析WSDL文件生成代码
            wsimport -s F:\\java -p com.ims.webService -keep http://192.168.1.33/service/helloService?wsdl
                -d：指定.class文件输出目录   -d F:\\src
                -s：指定.java文件输出目录
                -p：以package的形式生成文件
                -keep：是否生成java源文件
        2.把生成的代码复制到象奴中开始调用服务
            HelloServiceImplService helloServiceImplService = new HelloServiceImplService();
            HelloServiceImpl helloService = helloServiceImplService.getHelloServiceImplPort();
            System.out.println(helloService.say("大爷"));
