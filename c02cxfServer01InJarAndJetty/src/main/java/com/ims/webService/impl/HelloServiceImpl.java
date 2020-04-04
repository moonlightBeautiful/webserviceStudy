package com.ims.webService.impl;

import com.ims.model.Role;
import com.ims.model.User;
import com.ims.webService.HelloService;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebService
public class HelloServiceImpl implements HelloService {

    @Override
    public String say(String str) {
        System.out.println("我被" + str + "调用了");
        return "hello：" + str;
    }

    @Override
    public List<Role> getRoleByUser(User user) {
        List<Role> roleList = new ArrayList<Role>();
        // 模拟  直接写死
        if (user != null) {
            if (user.getUserName().equals("java1234") && user.getPassword().equals("123456")) {
                roleList.add(new Role(1, "技术总监"));
                roleList.add(new Role(2, "架构师"));
            } else if (user.getUserName().equals("jack") && user.getPassword().equals("123456")) {
                roleList.add(new Role(3, "程序员"));
            }
            return roleList;
        } else {
            return null;
        }
    }

}
