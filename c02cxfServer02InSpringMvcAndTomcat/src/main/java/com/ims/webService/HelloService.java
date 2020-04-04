package com.ims.webService;


import com.ims.model.Role;
import com.ims.model.User;

import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;
import java.util.Map;

@WebService
public interface HelloService {
    /**
     * 基本数据类型
     *
     * @param str
     * @return
     */
    String say(String str);
    /*

     */

    /**
     * 入参是javaBean 返回参数是List<javaBean>
     */
    List<Role> getRoleByUser(User user);

}
