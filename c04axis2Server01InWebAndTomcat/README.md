#axis2服务端
3种发布服务方式：
    1.简单的pojo方式（无需配置），了解即可
    2.打aar包的方式，太复杂，了解即可
    3.整合到web项目中发布，其实就是第2种的整合      
1.简单的pojo方式，了解即可
    1.官网下载axis2.war文件放到<Tomcat安装目录>\webapps目录中
        http://localhost:8080/axis2/ 验证
    2.把POJO类编译的class文件放到<Tomcat安装目录>\webapps\axis2\WEB-INF\pojo中（如果没有pojo目录，则建立该目录）
        POJO类不能使用package关键字声明包。
    3.启动tomcat
        http://localhost:8080/axis2/    页面中 点击Services 查看到发布的POJO类
        http://localhost:8080/axis2/services/Service类名/方法名?参数键值对1&参数键值对2
        Axis2在默认情况下可以热发布WebService，将WebService的.class文件复制到pojo目录中时，
        Tomcat不需要重新启动就可以自动发布WebService。
2.打aar包的方式，了解即可
    1.需要服务类class文件和services.xml文件，
        services.xml文件配置服务
        文件按照指定目录放
            D:\项目名\包路径com\sinosoft\webservice\服务类.class
            D:\项目名\META-INF必须这个目录\services.xml
    2.打包
        在windows控制台中进入项目名目录，并输入如下的命令生成.aar文件.
        jar cvf ws.aar .(注意：最后面是空格+小数点)
    3.最后将项目名.aar文件复制到<Tomcat安装目录>\webapps\axis2\WEB-INF\services目录中 
    4.启动Tomcat后，就可以调用这个WebService了
3.整合到web项目中发布：用这个
    1.引入axis2需要的jar包
    2.配置axis2
        解压axis2-war.zip，
            将axis2-web放项目Webapp目录下下
            将WEB-INF 下的 lib 、conf  、modules、views等文件夹移动到 AxisWebDemo工程的 WEB-INF目录下
        启动后，如果报缺少哪个，继续去 WEB-INF 下找
    3.配置web.xml
        webService前缀配置
    4.写一个简单的web服务类
        不用+注解
    5.配置要发布的服务类
        在/WEB-INF目录下创建：services文件夹
        在services文件夹下创建：任意名称文件夹  / META-INF / services.xml 
        services.xml 中部署要发布的类
            可以部署多个服务，在serviceGroup中写多个service
            也可以只部署一个服务，单个service为根节点
    6.发布测试
        http://localhost:8080/项目名/web.xml配置的url-pattern的值/services.xml配置的服务名?wsdl