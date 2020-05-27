#cxf学习
服务端：1.jar包中使用jetty
    1.引入依赖的3个jar包
    2.service和impl类上+注解@WebService
    3.发布服务：
        JaxWsServerFactoryBean发布服务
    4.测试是否成功：
        wsdl地址：http://192.168.1.3/service/helloService?wsdl    
    提示：
        1.数据类型
            1.基本、List、javabean和本地没啥区别
            2.返回参数是Map，需要适配器。好复杂，算了。
        2.拦截器：添加拦截器，可以不需要重新解析wsdl。
            1.内置拦截器
            2.自定义拦截器，可以获取消息头数据
                继承AbstractPhaseInterceptor<SoapMessage>
                1.构造方法：定义拦截机器类型，类似于前置、后置通知那种
                2.实现方法：handleMessage(SoapMessage soapMessage) 
                    soapMessage可 获取头消息 