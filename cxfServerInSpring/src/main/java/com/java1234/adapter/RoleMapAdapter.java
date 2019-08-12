package com.java1234.adapter;

import com.java1234.entity.Role;
import com.java1234.entity.RoleMap;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gaoxu
 * @date 2019-05-31 16:48
 * @description ... 类
 */
public class RoleMapAdapter extends XmlAdapter<RoleMap[], Map<String, List<Role>>> {
    /**
     * 适配转换 RoleArray[] -> Map<String, List<Role>>
     */
    @Override
    public Map<String, List<Role>> unmarshal(RoleMap[] roleArray) throws Exception {
        Map<String, List<Role>> map = new HashMap<String, List<Role>>();
        for (int i = 0; i < roleArray.length; i++) {
            RoleMap r = roleArray[i];
            map.put(r.getKey(), r.getValue());
        }
        return map;
    }

    /**
     * 适配转换 Map<String, List<Role>> -> MyRole[]
     */
    @Override
    public RoleMap[] marshal(Map<String, List<Role>> map) throws Exception {
        RoleMap[] roleArray = new RoleMap[map.size()];
        int i = 0;
        for (String key : map.keySet()) {
            roleArray[i] = new RoleMap();
            roleArray[i].setKey(key);
            roleArray[i].setValue(map.get(key));
            i++;
        }
        return roleArray;
    }
}
