package com.java1234.entity;

import java.util.List;

/**
 * @author gaoxu
 * @date 2019-05-31 16:48
 * @description ... 类
 */
public class RoleMap {
    private String key;
    private List<Role> value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Role> getValue() {
        return value;
    }

    public void setValue(List<Role> value) {
        this.value = value;
    }
}
