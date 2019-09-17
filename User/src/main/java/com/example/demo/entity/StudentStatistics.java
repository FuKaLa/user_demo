package com.example.demo.entity;

import com.example.demo.utils.IsNeeded;

import java.math.BigDecimal;

public class StudentStatistics {
    private Integer id;
    @IsNeeded
    private BigDecimal totalGrade;
    @IsNeeded
    private BigDecimal avgGrade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getTotalGrade() {
        return totalGrade;
    }

    public void setTotalGrade(BigDecimal totalGrade) {
        this.totalGrade = totalGrade;
    }

    public BigDecimal getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(BigDecimal avgGrade) {
        this.avgGrade = avgGrade;
    }

    @Override
    public String
    toString() {
        return "StudentStatistics{" +
                "id=" + id +
                ", totalGrade=" + totalGrade +
                ", avgGrade=" + avgGrade +
                '}';
    }
}
