cxf：
    服务端
        1.引入依赖的3个jar包
        2.service和impl类上+注解@WebService
        3.发布服务：JaxWsServerFactoryBean
        4.wsdl地址：http://192.168.1.33/service/helloService?wsdl    
        数据类型
            1.基本、List、javabean和本地没啥区别
            2.返回参数是Map，需要适配器。好复杂，算了。
        拦截器：拦截发布的方法，先进后出。
            添加拦截器，可以断不需要重新解析wsdl。
            1.内置拦截器
            2.自定义拦截器，可以获取消息头数据
                继承AbstractPhaseInterceptor<SoapMessage>
                1.构造方法：定义拦截机器类型，
                    有很多种，用到的时候百度吧
                2.实现方法：handleMessage(SoapMessage soapMessage) 
                    soapMessage可 获取头消息 
        springMVC整合cxf，也就是spring来自动发布webservice
            1.引入相关jar包
            2.web.xml配置
                1.加载spring 监听器和配置文件
                2.使用CXFServlet处理调用发布服务的请求
            3.编码service类和拦截器类
            4.spring的xml文件配置
                1.引入cxk的xml文件，为了spring来实例化bean
                    cxf-core和cxf-rt-transports-http的jar包可以看到引入的xml文件
                2.实例化bean发布服务实现类
                3.定义发布者
                    发布服务实现类实例，服务地址（要拼接web.xml中CXF请求后面）
            5.客户端要根据wsdl从新生成下代码，调用方式和原来一样
    客户端
        1.cxf解析wsdl，官网下载
            1.环境变量配置，可以不配置，需要进入到cxf的bin目录下执行
                CXF_HOME    D:\apache-cxf-3.1.5
                Path        ;%CXF_HOME%\bin
            2.cmd中使用cxf解析wsdl生成代码
                wsdl2java -d F:\\java -p com.ims.webService com. http://ip地址/服务?wsdl
                    -d 输出目录               
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