cxf学习：
    1.发布服务
       在web.xml中配置spring监听器和CXFServlet类
       在applicationContext.xml中配置cxf-core包自带的自带的2个配置文件和定义服务提供者、服务名和扫描服务类
       在服务类上添加注解@Component("helloWorld")
    最后启动tomcat即可
        地址是ip+web.xml中的前缀+applicationContext.xml中的服务名
        http://localhost:8080/webservice/HelloWorld?wsdl