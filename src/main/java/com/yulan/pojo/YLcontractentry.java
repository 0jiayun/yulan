package com.yulan.pojo;
/*
*网签协议表
 */


import java.sql.Date;

public class YLcontractentry {

    private Integer cYear;
    private String cid;
    private String xDistrict;
    private String xAreaDistrict2;
    private String xAreaDistrict3;
    private Date startDate;
    private Date endDate;
    private String typeID;
    private String tableName;
    private String pageName;
    private String state;
    private String wfMemo;
    private String aOwner;
    private Date signts;
    private Integer signed;
    private Integer legalChecked;
    private String rwUpdate;

    public Integer getcYear() {
        return cYear;
    }

    public void setcYear(Integer cYear) {
        this.cYear = cYear;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getxDistrict() {
        return xDistrict;
    }

    public void setxDistrict(String xDistrict) {
        this.xDistrict = xDistrict;
    }

    public String getxAreaDistrict2() {
        return xAreaDistrict2;
    }

    public void setxAreaDistrict2(String xAreaDistrict2) {
        this.xAreaDistrict2 = xAreaDistrict2;
    }

    public String getxAreaDistrict3() {
        return xAreaDistrict3;
    }

    public void setxAreaDistrict3(String xAreaDistrict3) {
        this.xAreaDistrict3 = xAreaDistrict3;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getWfMemo() {
        return wfMemo;
    }

    public void setWfMemo(String wfMemo) {
        this.wfMemo = wfMemo;
    }

    public String getaOwner() {
        return aOwner;
    }

    public void setaOwner(String aOwner) {
        this.aOwner = aOwner;
    }

    public Date getSignts() {
        return signts;
    }

    public void setSignts(Date signts) {
        this.signts = signts;
    }

    public Integer getSigned() {
        return signed;
    }

    public void setSigned(Integer signed) {
        this.signed = signed;
    }

    public Integer getLegalChecked() {
        return legalChecked;
    }

    public void setLegalChecked(Integer legalChecked) {
        this.legalChecked = legalChecked;
    }

    public String getRwUpdate() {
        return rwUpdate;
    }

    public void setRwUpdate(String rwUpdate) {
        this.rwUpdate = rwUpdate;
    }
}
