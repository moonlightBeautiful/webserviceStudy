#cxf客户端
1.cxf解析wsdl，官网下载
    1.环境变量配置，可以不配置，需要进入到cxf的bin目录下执行
        CXF_HOME    D:\apache-cxf-3.1.5
        Path        ;%CXF_HOME%\bin
    2.cmd中使用cxf解析wsdl生成代码
        wsdl2java -d F:\\java -p com.ims.webService http://192.168.1.3/service/helloService?wsdl
            -d java文件输出目录
            -p 生成代码的包路径             
2.把生成的代码复制到包中开始调用服务：如果不使用cxf其他功能拦截器等，不需要引入cxf包
    HelloServiceService helloServiceService = new HelloServiceService();
    HelloService helloService = helloServiceService.getHelloServicePort();
    System.out.println(helloService.say("大爷"));        
拦截器：拦截调用发布方法，先出后进
    添加拦截器，可以断不需要重新解析wsdl。
    客户端也可以添加拦截器
        类型有很多种，用到的时候百度吧
        1.内置拦截器
        2.自定义拦截器，可以向消息头添加数据
            继承AbstractPhaseInterceptor<SoapMessage>
            1.构造方法：定义拦截机器类型，
                有很多种，用到的时候百度吧
            2.实现方法：handleMessage(SoapMessage soapMessage) 
                soapMessage可 获取头消息    