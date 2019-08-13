1.axis2发布方式：需要借助axis2.war。
    1.简单的pojo方式（无需配置）
        1.把axis2.war文件放到<Tomcat安装目录>\webapps目录中
            http://localhost:8080/axis2/
            如果地址通，则OK
        2.把POJO类编译的class文件放到<Tomcat安装目录>\webapps\axis2\WEB-INF\pojo中（如果没有pojo目录，则建立该目录）
            POJO类不能使用package关键字声明包。
        3.启动tomcat
            http://localhost:8080/axis2/    页面中 点击Services 查看到发布的POJO类
            http://localhost:8080/axis2/services/Service类名/方法名?参数键值对1&参数键值对2
            Axis2在默认情况下可以热发布WebService，将WebService的.class文件复制到pojo目录中时，Tomcat不需要重新启动就可以自动发布WebService。
    2.打jar包的方式:这种方式太难了，算了，知道有这种方式就行
        1.需要服务类的编译文件class和services.xml
        2.这两个文件放到指定目录中
            D:\ws\ com\sinosoft\webservice\HelloServiceNew.class
            D:\ws\META-INF\services.xml
        3.在windows控制台中进入ws目录，并输入如下的命令生成.aar文件.
            jar cvf ws.aar .(注意：最后面是空格+小数点)
        4.最后将ws.aar文件复制到<Tomcat安装目录>\webapps\axis2\WEB-INF\services目录中
        5.启动Tomcat后，就可以调用这个WebService了
    3.集成在项目中发布webservice
        1.pom引入jar包 
        2.拷贝axis2-web到webapp下
        3.web.xml中配置axis-servlet
        4.HelloService类
        5.WEB-INF/services/服务模块/META-INF目录下service.xml中配置发布类
        6.启动tomcat访问
            wsdl文件的地址：
                http://localhost:8080/项目名(axis2ServerInWebApp)，如果idea中没有配置，则不写/services/services
                    .xml中配置的服务名（HelloService）?wsdl
                    http://localhost:8080/services/HelloService?wsdl
            调用方法：
                http://localhost:8090/项目名(axis2ServerInWebApp)，如果idea中没有配置，则不写/services/services
                    .xml中配置的服务名（HelloService）/方法(sayHello)
                    http://localhost:8090/services/HelloService/sayHello
                http://localhost:8090/项目名(axis2ServerInWebApp)，如果idea中没有配置，则不写/services/services
                    .xml中配置的服务名（HelloService）/方法?键值对&键值对(sayHelloToPerson?name=gaoxu)
                    http://localhost:8090/services/HelloService/sayHelloToPerson?name=gaoxu
                   