package com.example.demo.controller;

import java.math.BigDecimal;

public class TestC {
    public static void main(String[] args) {
        System.out.println(new BigDecimal("575.22").multiply(new BigDecimal("0.6").divide(new BigDecimal(100))).setScale(2, BigDecimal.ROUND_UP).doubleValue());
    }
}
