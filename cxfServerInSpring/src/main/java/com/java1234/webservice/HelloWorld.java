package com.java1234.webservice;

/**
 * @author gaoxu
 * @date 2019-05-20 18:03
 * @description ... 类
 */

import com.java1234.adapter.RoleMapAdapter;
import com.java1234.entity.Role;
import com.java1234.entity.User;

import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;
import java.util.Map;

@WebService
public interface HelloWorld {
    public String say(String str);

    /**
     * 参数是List
     */
    public List<Role> getRoleByUser(User user);

    /* */

    /**
     * 参数是Map
     * CXF是无法直接操作Map类型的数据的，需要一些转换工作
     */
    @XmlJavaTypeAdapter(RoleMapAdapter.class)
    public Map<String, List<Role>> getRoles();

}
