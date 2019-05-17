package com.example.demo.entity;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 6822749436238325284L;
    private String id;

    private String name;

    private String sex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public User(String id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }
}
