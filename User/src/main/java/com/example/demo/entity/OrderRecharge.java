package com.example.demo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderRecharge implements Serializable {
    /**
     * 订单号
     */
    private String orderId;
    /**
     * 交易流水号
     */
    private String ticketId;
    /**
     * 原交易单据号
     */
    private String billId;
    /**
     * 卡号
     */
    private String cardNo;
    /**
     * 卡号密码
     */
    private String password;
    /**
     * 交易类型:W 微信 Z 支付宝 B 银行卡 C 现金 E pos通微信 F pos通支付宝 U pos通银行卡
     */
    private String payType;
    /**
     * 交易金额
     */
    private BigDecimal payAmount;
    /**
     * 返利金额
     */
    private BigDecimal rebateAmount;
    /**
     * 交易时间
     */
    private Date payTime;
    /**
     * 营业日
     */
    private String workday;
    /**
     * 班次
     */
    private String shiftNo;
    /**
     * 油站编号
     */
    private String stationCode;
    /**
     * 站点名称
     */
    private String stationName;
    /**
     * 订单支付状态:00 支付成功 01待支付 02支付失败
     */
    private String status;
    /**
     * 订单充值状态:00 充值成功 01待充值 02充值失败
     */
    private String rechargeStatus;
    /**
     * 账户余额
     */
    private BigDecimal balanceAmount;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 修改人
     */
    private String modifier;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 支付账户
     */
    private String payAccount;
    /**
     * 支付条码
     */
    private String barCode;
    /**
     * 终端编号
     */
    private String termId;
    /**
     * 支付通道:0:非pos通支付(不包含现金)(支付网关支付) 1:pos通支付 2:现金支付 3:edc(680,520)支付
     */
    private String payGetway;
    private String userId;
    /**
     * 10.会员用户，20实体储值卡用户
     */
    private Integer userType;
    /**
     * 开票状态，0.未开票；1.开票中；2.已开票
     */
    private Integer invoiceStatus;

    /**
     * 卡类型，0.实体储值卡，1.电子储值卡
     */
    private Integer cardType;


    private Integer srcType;

    private String srcOrderId;

    private String tenantId;

    private String srcCode;
    /**
     * 交易通道
     */
    private String transChannel;

    private String orderType;

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getTransChannel() {
        return transChannel;
    }

    public void setTransChannel(String transChannel) {
        this.transChannel = transChannel;
    }

    public String getSrcCode() {
        return srcCode;
    }

    public void setSrcCode(String srcCode) {
        this.srcCode = srcCode;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getSrcOrderId() {
        return srcOrderId;
    }

    public void setSrcOrderId(String srcOrderId) {
        this.srcOrderId = srcOrderId;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public Integer getSrcType() {
        return srcType;
    }

    public void setSrcType(Integer srcType) {
        this.srcType = srcType;
    }
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getRebateAmount() {
        return rebateAmount;
    }

    public void setRebateAmount(BigDecimal rebateAmount) {
        this.rebateAmount = rebateAmount;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getWorkday() {
        return workday;
    }

    public void setWorkday(String workday) {
        this.workday = workday;
    }

    public String getShiftNo() {
        return shiftNo;
    }

    public void setShiftNo(String shiftNo) {
        this.shiftNo = shiftNo;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRechargeStatus() {
        return rechargeStatus;
    }

    public void setRechargeStatus(String rechargeStatus) {
        this.rechargeStatus = rechargeStatus;
    }

    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getTermId() {
        return termId;
    }

    public void setTermId(String termId) {
        this.termId = termId;
    }

    public String getPayGetway() {
        return payGetway;
    }

    public void setPayGetway(String payGetway) {
        this.payGetway = payGetway;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(Integer invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    @Override
    public String toString() {
        return "{" +
                "orderId='" + orderId + '\'' +
                ", ticketId='" + ticketId + '\'' +
                ", billId='" + billId + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", password='" + password + '\'' +
                ", payType='" + payType + '\'' +
                ", payAmount=" + payAmount +
                ", rebateAmount=" + rebateAmount +
                ", payTime:" + payTime +
                ", workday='" + workday + '\'' +
                ", shiftNo='" + shiftNo + '\'' +
                ", stationCode='" + stationCode + '\'' +
                ", stationName='" + stationName + '\'' +
                ", status='" + status + '\'' +
                ", rechargeStatus='" + rechargeStatus + '\'' +
                ", balanceAmount=" + balanceAmount +
                ", remark='" + remark + '\'' +
                ", creator='" + creator + '\'' +
                ", modifier='" + modifier + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", payAccount='" + payAccount + '\'' +
                ", barCode='" + barCode + '\'' +
                ", termId='" + termId + '\'' +
                ", payGetway='" + payGetway + '\'' +
                ", userId='" + userId + '\'' +
                ", userType=" + userType +
                ", invoiceStatus=" + invoiceStatus +
                ", cardType=" + cardType +
                ", srcType=" + srcType +
                ", srcOrderId='" + srcOrderId + '\'' +
                ", tenantId='" + tenantId + '\'' +
                ", srcCode='" + srcCode + '\'' +
                ", transChannel='" + transChannel + '\'' +
                ", orderType='" + orderType + '\'' +
                '}';
    }
}
