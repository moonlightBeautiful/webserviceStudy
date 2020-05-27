#cxf学习：
服务端:2.springMVC整合cxf，也就是spring来自动发布webservice
    1.引入相关jar包
    2.web.xml配置
        1.加载spring 监听器和配置文件
        2.配置CXFServlet处理调用发布服务的请求
            wsdl文件地址：ip/url-pattern的值/服务名?wsdl
    3.编码service类和拦截器类
        记得加注解
    4.spring的xml文件配置
        1.实例化bean，要发布的服务实现类
        2.引入cxf包自带的的xml文件
            cxf-core和cxf-rt-transports-http的jar包可以看到引入的xml文件
        3.定义发布者
            配置要发布的服务、服务地址、拦截器等  
    5.测试是否发布成功
        http://192.168.1.3:8080/c02cxfServer02InSpringMvcAndTomcat_war_exploded/webservice/helloService?wsdl
        