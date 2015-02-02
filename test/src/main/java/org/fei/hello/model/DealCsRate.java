package org.fei.hello.model;


public class DealCsRate {

    private Long id;
    //更新时间，创建时间
    private String updateTime,createdTime;

    private Long dealId, userId, level1, level2, level3,argueNum;// 1,2,3级

    private String name1, name2, name3;// 1,2,3级名称

    private String type, csRate, level;// 投诉类型,比例,po级别

    private String description;//投诉内容

    //处理状态
    private String status;


    public Long getArgueNum() {
        return argueNum;
    }

    public void setArgueNum(Long argueNum) {
        this.argueNum = argueNum;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getLevel1() {
        return level1;
    }

    public void setLevel1(Long level1) {
        this.level1 = level1;
    }

    public Long getLevel2() {
        return level2;
    }

    public void setLevel2(Long level2) {
        this.level2 = level2;
    }

    public Long getLevel3() {
        return level3;
    }

    public void setLevel3(Long level3) {
        this.level3 = level3;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    private static final long serialVersionUID = 132L;

    public Long getDealId() {
        return dealId;
    }

    public void setDealId(Long dealId) {
        this.dealId = dealId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCsRate() {
        return csRate;
    }

    public void setCsRate(String csRate) {
        int len = csRate.length() - csRate.indexOf(".") > 3 ? 3 : csRate
                .length() - csRate.indexOf(".");
        this.csRate = csRate == null ? "" : csRate.substring(0,
                csRate.indexOf(".") + len);
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return "id: "+id+" updateTime: "+updateTime+" name1: "+name1+" name2:"+name2+" name3:"+name3;
    }

}
