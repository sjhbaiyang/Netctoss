package com.lanou.bean;

import java.util.Date;

public class Account {
    private Integer accountId;

    private Integer recommenderId;

    private String loginName;

    private String loginPasswd;

    private String status;

    //创建时间
    private String createDate;

    //暂停时间
    private String pauseDate;

    //删除时间
    private String closeDate;

    //姓名
    private String realName;

    private String idcardNo;

    private String birthdate;

    private String gender;

    //职业
    private String occupation;

    private String telephone;

    private String email;

    private String mailaddress;
    //邮编
    private String zipcode;

    private String qq;

    //上次登录时间
    private String lastLoginTime;

    //上次登录地址
    private String lastLoginIp;

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", recommenderId=" + recommenderId +
                ", loginName='" + loginName + '\'' +
                ", loginPasswd='" + loginPasswd + '\'' +
                ", status='" + status + '\'' +
                ", createDate=" + createDate +
                ", pauseDate=" + pauseDate +
                ", closeDate=" + closeDate +
                ", realName='" + realName + '\'' +
                ", idcardNo='" + idcardNo + '\'' +
                ", birthdate=" + birthdate +
                ", gender='" + gender + '\'' +
                ", occupation='" + occupation + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", mailaddress='" + mailaddress + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", qq='" + qq + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                '}';
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getRecommenderId() {
        return recommenderId;
    }

    public void setRecommenderId(Integer recommenderId) {
        this.recommenderId = recommenderId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getLoginPasswd() {
        return loginPasswd;
    }

    public void setLoginPasswd(String loginPasswd) {
        this.loginPasswd = loginPasswd == null ? null : loginPasswd.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getPauseDate() {
        return pauseDate;
    }

    public void setPauseDate(String pauseDate) {
        this.pauseDate = pauseDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo == null ? null : idcardNo.trim();
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation == null ? null : occupation.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMailaddress() {
        return mailaddress;
    }

    public void setMailaddress(String mailaddress) {
        this.mailaddress = mailaddress == null ? null : mailaddress.trim();
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode == null ? null : zipcode.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }
}