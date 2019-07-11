package com.example.demo.entity;

import java.io.Serializable;

/**
 * 用于重复推送订单
 */
public class OrderRechargeMsg implements Serializable {
    private String ticketId;
    private OrderRecharge orderRecharge;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public OrderRecharge getOrderRecharge() {
        return orderRecharge;
    }

    public void setOrderRecharge(OrderRecharge orderRecharge) {
        this.orderRecharge = orderRecharge;
    }
}
