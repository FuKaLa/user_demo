package com.example.demo.entity;
public  class  IncomeSumPojo {

     String id;
      String name;
     String sex;
    Double surplus_num;

    public Double getSurplus_num() {
        return surplus_num;
    }

    public void setSurplus_num(Double surplus_num) {
        this.surplus_num = surplus_num;
    }

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

    public IncomeSumPojo(String id, String name, String sex,Double surplus_num) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.surplus_num = surplus_num;
    }

    @Override
    public String toString() {
        return "IncomeSumPojo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", surplus_num=" + surplus_num +
                '}';
    }
}

