package com.example.demo.entity;

import com.example.demo.utils.IsNeeded;

import java.math.BigDecimal;

public class StudentBaseInfo {
    private Integer id;
    @IsNeeded
    private String no;
    @IsNeeded
    private String name;
    @IsNeeded
    private String idnum;
    @IsNeeded
    private String sex;
    @IsNeeded
    private BigDecimal grade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdnum() {
        return idnum;
    }

    public void setIdnum(String idnum) {
        this.idnum = idnum;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "StudentBaseInfo{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", idnum='" + idnum + '\'' +
                ", sex='" + sex + '\'' +
                ", grade=" + grade +
                '}';
    }
}
