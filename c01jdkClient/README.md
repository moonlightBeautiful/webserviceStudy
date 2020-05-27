JDK：依赖jdk1.6以上
客户端
    1.使用JDK自带的工具wsimport解析WSDL文件生成java源代码，复制到自己的项目中
        wsimport -s F:\\java -p com.ims.webService http://192.168.1.3/service/helloService?wsdl
            -d：指定.class文件输出目录   -d F:\\src    一般不需要
            -s：指定.java文件输出目录
            -p：以package的形式生成文件
    2.调用服务
        HelloServiceImplService helloServiceImplService = new HelloServiceImplService();
        HelloServiceImpl helloService = helloServiceImplService.getHelloServiceImplPort();
        System.out.println(helloService.say("大爷"));