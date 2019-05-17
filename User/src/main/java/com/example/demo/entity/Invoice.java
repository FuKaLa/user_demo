package com.example.demo.entity;

import java.util.List;

public class Invoice {
    private List<RequestBean> cards;

    private String channel;

    private String stationCode;

    public List<RequestBean> getCards() {
        return cards;
    }

    public void setCards(List<RequestBean> cards) {
        this.cards = cards;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public class RequestBean {
        private String cardNo;
        private String cardType;

        public String getCardNo() {
            return cardNo;
        }

        public void setCardNo(String cardNo) {
            this.cardNo = cardNo;
        }

        public String getCardType() {
            return cardType;
        }

        public void setCardType(String cardType) {
            this.cardType = cardType;
        }

        public RequestBean(String cardNo, String cardType) {
            this.cardNo = cardNo;
            this.cardType = cardType;
        }
    }
}
