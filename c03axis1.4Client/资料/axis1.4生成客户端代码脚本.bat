::axis.jar所在目录
set axis_Lib=D:\apache-axis-1_4\lib

::生成客户端的代码所在文件
set output_Path=F:\my
 
::生成客户端的代码所在包
set package=com.java1234

::wsdl地址
set wsdlAdress=http://localhost:8090/services/HelloService?wsdl

set java_Cmd=java -Djava.ext.dirs=%Axis_Lib%
%java_Cmd% org.apache.axis.wsdl.WSDL2Java -o %output_Path% -p %package% %wsdlAdress%
pause;