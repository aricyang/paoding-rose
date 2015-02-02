package org.fei.hello.model;

import java.lang.Long;
import java.text.DecimalFormat;
import java.util.Calendar;

import org.apache.commons.lang.StringUtils;


public class FactRptDayDealExt extends FactRptDayDeal {

    //合同号
    protected String contractId;

    protected Double marketMoney;

    protected Double localMoney;

    protected Double localGrossProfit;

    protected Integer timeUnit;

    protected double satisRate;

    protected double discount;

    protected double localDiscount;

    protected Integer salerCount;

    protected double aveMoney;

    protected double aveGross;

    protected Integer sellAreaType;

    protected Integer dealCount;

    protected double grossProfitRateValue;

    protected String grossProfitRate;

    protected String totalMoneyString;

    protected String grossProfitString;

    protected String timeArea;

    protected double discountString;

    protected long timeAreaId;

    protected String categoryNameString;

    protected double satisRateString;

    protected long saleDealCount;

    protected long canyinSaleDealCount;

    protected double avgScore;

    protected double satisRateString1;

    protected String payStartTimeStr;

    protected String payEndTimeStr;

    protected String dealStartTimeStr;

    protected String dealExpireTimeStr;

    protected Integer payStartTimeInt;

    protected Integer payEndTimeInt;

    protected Double grossProfitDouble;

    protected Double aveMoneyDouble;

    protected Double aveGrossDouble;

    protected Double grossProfitAdjust;

    protected Double localGrossProfitAdjust;

    protected Double aveGrossProfitAdjust;

    protected Double refundGrossProfit;

    // 增加业绩流水、业绩毛利、业绩人均流水、业绩人均毛利、退款金额、业绩折扣
    protected Double totalMoneyPerf;

    protected Double localTotalMoneyPerf;

    protected Double grossProfitPerf;

    protected Double localGrossProfitPerf;

    protected Double aveTotalMoneyPerf;

    protected Double aveGrossProfitPerf;

    protected Double marketFee;

    protected int onlineDealCount;

    protected int canyinOnlineDealCount;

    protected int onlineCustomCount;

    protected Double adRate;//广告费

    protected Integer isAllNew;//绝对新单

    protected Integer canyinIsAllNew;

    protected String platform;
    protected String type;
    protected Double contractPrice;

    protected Integer hidden;

    protected String hiddenStr;
    //分店id
    protected String firmIds;


    /*在线分店、餐饮、电影、KTV数，糯米独家在线分店、餐饮、电影、KTV数*/
    protected Integer firmCount,canyinFirmCount,movieFirmCount,ktvFirmCount;
    protected Integer firmCountOnly,canyinFirmCountOnly,movieFirmCountOnly,ktvFirmCountOnly;

    protected String customName;// 商家名称
    protected int ddealId;//
    protected double dongXiaoRate;//动销比
    protected int onlineDealDx;//在线单
    protected int dxCount;//动销单量
    protected int customId;//
    protected int startDate;//
    protected int endDate;//
    private String qGroup;
    private int totalCount;
    protected String statTotalMoneyByDay;//日均流水
    protected String statBuyCountByDay;//日均销量
    protected String statTotalMoneyPerfByDay;//毛利日均流水

	/*随时退*/

    protected Integer sevenRefund;

    protected String sevenRefundStr;

    /*过期退*/
    protected Integer expireRefund;

    protected String expireRefundStr;

    /*结算类型*/
    protected Integer payType;

    protected String payTypeStr;

    /*艺龙*/
    protected Integer isElong;
    protected String isElongStr;

    /*快递类型*/
    protected String needSendStr;

    /*是否实时团购*/
    protected Integer isSelfService;

    protected String isSelfServiceStr;

    /*是否零元单*/
    protected Integer isZero;

    protected String isZeroStr;

    /*是否站外码*/
    protected Integer otherSiteCode;

    protected String otherSiteCodeStr;

    /*是否二维码*/
    protected Integer isTwoDim;

    protected String isTwoDimStr;

    /*是否本地单*/
    protected Integer isLocal;

    protected String isLocalStr;

    /*是否搜折单*/
    protected Integer isSouzhe;

    protected String isSouzheStr;

    /*是否绝对新单*/
    protected String isAllNewStr;

    /*取消验证数*/
    protected Integer certiCancelCount;

    /*售价*/
    protected Double currentPrice;

    /*乙方名称*/
    protected String oldFirmName;

    /*单子状态*/
    protected Integer status;

    protected String statusStr;

    protected Long pv;

    protected Long uv;

    protected Long visit;

    protected String grossProfitAdjustString;


    @Override
    public String toString() {
        return "contractId: "+contractId+" saleName: "+saleName;
    }

    public String getGrossProfitAdjustString() {
        return grossProfitAdjustString;
    }

    public void setGrossProfitAdjustString(String grossProfitAdjustString) {
        this.grossProfitAdjustString = grossProfitAdjustString;
    }



    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public Double getMarketMoney() {
        return marketMoney;
    }

    public void setMarketMoney(Double marketMoney) {
        this.marketMoney = marketMoney;
    }

    public Double getLocalMoney() {
        return localMoney;
    }

    public void setLocalMoney(Double localMoney) {
        this.localMoney = localMoney;
    }

    public Double getLocalGrossProfit() {
        return localGrossProfit;
    }

    public void setLocalGrossProfit(Double localGrossProfit) {
        this.localGrossProfit = localGrossProfit;
    }

    public Integer getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(Integer timeUnit) {
        this.timeUnit = timeUnit;
    }

    public double getSatisRate() {
        return satisRate;
    }

    public void setSatisRate(double satisRate) {
        this.satisRate = satisRate;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getLocalDiscount() {
        return localDiscount;
    }

    public void setLocalDiscount(double localDiscount) {
        this.localDiscount = localDiscount;
    }

    public Integer getSalerCount() {
        return salerCount;
    }

    public void setSalerCount(Integer salerCount) {
        this.salerCount = salerCount;
    }

    public double getAveMoney() {
        return aveMoney;
    }

    public void setAveMoney(double aveMoney) {
        this.aveMoney = aveMoney;
    }

    public double getAveGross() {
        return aveGross;
    }

    public void setAveGross(double aveGross) {
        this.aveGross = aveGross;
    }

    public Integer getSellAreaType() {
        return sellAreaType;
    }

    public void setSellAreaType(Integer sellAreaType) {
        this.sellAreaType = sellAreaType;
    }

    public Integer getDealCount() {
        return dealCount;
    }

    public void setDealCount(Integer dealCount) {
        this.dealCount = dealCount;
    }

    public double getGrossProfitRateValue() {
        return grossProfitRateValue;
    }

    public void setGrossProfitRateValue(double grossProfitRateValue) {
        this.grossProfitRateValue = grossProfitRateValue;
    }

    public String getGrossProfitRate() {
        return grossProfitRate;
    }

    public void setGrossProfitRate(String grossProfitRate) {
        this.grossProfitRate = grossProfitRate;
    }

    public String getTotalMoneyString() {
        return totalMoneyString;
    }

    public void setTotalMoneyString(String totalMoneyString) {
        this.totalMoneyString = totalMoneyString;
    }

    public String getGrossProfitString() {
        return grossProfitString;
    }

    public void setGrossProfitString(String grossProfitString) {
        this.grossProfitString = grossProfitString;
    }

    public String getTimeArea() {
        return timeArea;
    }

    public void setTimeArea(String timeArea) {
        this.timeArea = timeArea;
    }

    public double getDiscountString() {
        return discountString;
    }

    public void setDiscountString(double discountString) {
        this.discountString = discountString;
    }

    public long getTimeAreaId() {
        return timeAreaId;
    }

    public void setTimeAreaId(long timeAreaId) {
        this.timeAreaId = timeAreaId;
    }

    public String getCategoryNameString() {
        return categoryNameString;
    }

    public void setCategoryNameString(String categoryNameString) {
        this.categoryNameString = categoryNameString;
    }

    public double getSatisRateString() {
        return satisRateString;
    }

    public void setSatisRateString(double satisRateString) {
        this.satisRateString = satisRateString;
    }

    public long getSaleDealCount() {
        return saleDealCount;
    }

    public void setSaleDealCount(long saleDealCount) {
        this.saleDealCount = saleDealCount;
    }

    public long getCanyinSaleDealCount() {
        return canyinSaleDealCount;
    }

    public void setCanyinSaleDealCount(long canyinSaleDealCount) {
        this.canyinSaleDealCount = canyinSaleDealCount;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    public double getSatisRateString1() {
        return satisRateString1;
    }

    public void setSatisRateString1(double satisRateString1) {
        this.satisRateString1 = satisRateString1;
    }

    public String getPayStartTimeStr() {
        return payStartTimeStr;
    }

    public void setPayStartTimeStr(String payStartTimeStr) {
        this.payStartTimeStr = payStartTimeStr;
    }

    public String getPayEndTimeStr() {
        return payEndTimeStr;
    }

    public void setPayEndTimeStr(String payEndTimeStr) {
        this.payEndTimeStr = payEndTimeStr;
    }

    public String getDealStartTimeStr() {
        return dealStartTimeStr;
    }

    public void setDealStartTimeStr(String dealStartTimeStr) {
        this.dealStartTimeStr = dealStartTimeStr;
    }

    public String getDealExpireTimeStr() {
        return dealExpireTimeStr;
    }

    public void setDealExpireTimeStr(String dealExpireTimeStr) {
        this.dealExpireTimeStr = dealExpireTimeStr;
    }

    public Integer getPayStartTimeInt() {
        return payStartTimeInt;
    }

    public void setPayStartTimeInt(Integer payStartTimeInt) {
        this.payStartTimeInt = payStartTimeInt;
    }

    public Integer getPayEndTimeInt() {
        return payEndTimeInt;
    }

    public void setPayEndTimeInt(Integer payEndTimeInt) {
        this.payEndTimeInt = payEndTimeInt;
    }

    public Double getGrossProfitDouble() {
        return grossProfitDouble;
    }

    public void setGrossProfitDouble(Double grossProfitDouble) {
        this.grossProfitDouble = grossProfitDouble;
    }

    public Double getAveMoneyDouble() {
        return aveMoneyDouble;
    }

    public void setAveMoneyDouble(Double aveMoneyDouble) {
        this.aveMoneyDouble = aveMoneyDouble;
    }

    public Double getAveGrossDouble() {
        return aveGrossDouble;
    }

    public void setAveGrossDouble(Double aveGrossDouble) {
        this.aveGrossDouble = aveGrossDouble;
    }

    public Double getGrossProfitAdjust() {
        return grossProfitAdjust;
    }

    public void setGrossProfitAdjust(Double grossProfitAdjust) {
        this.grossProfitAdjust = grossProfitAdjust;
    }

    public Double getLocalGrossProfitAdjust() {
        return localGrossProfitAdjust;
    }

    public void setLocalGrossProfitAdjust(Double localGrossProfitAdjust) {
        this.localGrossProfitAdjust = localGrossProfitAdjust;
    }

    public Double getAveGrossProfitAdjust() {
        return aveGrossProfitAdjust;
    }

    public void setAveGrossProfitAdjust(Double aveGrossProfitAdjust) {
        this.aveGrossProfitAdjust = aveGrossProfitAdjust;
    }

    public Double getRefundGrossProfit() {
        return refundGrossProfit;
    }

    public void setRefundGrossProfit(Double refundGrossProfit) {
        this.refundGrossProfit = refundGrossProfit;
    }

    public Double getTotalMoneyPerf() {
        return totalMoneyPerf;
    }

    public void setTotalMoneyPerf(Double totalMoneyPerf) {
        this.totalMoneyPerf = totalMoneyPerf;
    }

    public Double getLocalTotalMoneyPerf() {
        return localTotalMoneyPerf;
    }

    public void setLocalTotalMoneyPerf(Double localTotalMoneyPerf) {
        this.localTotalMoneyPerf = localTotalMoneyPerf;
    }

    public Double getGrossProfitPerf() {
        return grossProfitPerf;
    }

    public void setGrossProfitPerf(Double grossProfitPerf) {
        this.grossProfitPerf = grossProfitPerf;
    }

    public Double getLocalGrossProfitPerf() {
        return localGrossProfitPerf;
    }

    public void setLocalGrossProfitPerf(Double localGrossProfitPerf) {
        this.localGrossProfitPerf = localGrossProfitPerf;
    }

    public Double getAveTotalMoneyPerf() {
        return aveTotalMoneyPerf;
    }

    public void setAveTotalMoneyPerf(Double aveTotalMoneyPerf) {
        this.aveTotalMoneyPerf = aveTotalMoneyPerf;
    }

    public Double getAveGrossProfitPerf() {
        return aveGrossProfitPerf;
    }

    public void setAveGrossProfitPerf(Double aveGrossProfitPerf) {
        this.aveGrossProfitPerf = aveGrossProfitPerf;
    }

    public Double getMarketFee() {
        return marketFee;
    }

    public void setMarketFee(Double marketFee) {
        this.marketFee = marketFee;
    }

    public int getOnlineDealCount() {
        return onlineDealCount;
    }

    public void setOnlineDealCount(int onlineDealCount) {
        this.onlineDealCount = onlineDealCount;
    }

    public int getCanyinOnlineDealCount() {
        return canyinOnlineDealCount;
    }

    public void setCanyinOnlineDealCount(int canyinOnlineDealCount) {
        this.canyinOnlineDealCount = canyinOnlineDealCount;
    }

    public int getOnlineCustomCount() {
        return onlineCustomCount;
    }

    public void setOnlineCustomCount(int onlineCustomCount) {
        this.onlineCustomCount = onlineCustomCount;
    }

    public Double getAdRate() {
        return adRate;
    }

    public void setAdRate(Double adRate) {
        this.adRate = adRate;
    }

    public Integer getIsAllNew() {
        return isAllNew;
    }

    public void setIsAllNew(Integer isAllNew) {
        this.isAllNew = isAllNew;
    }

    public Integer getCanyinIsAllNew() {
        return canyinIsAllNew;
    }

    public void setCanyinIsAllNew(Integer canyinIsAllNew) {
        this.canyinIsAllNew = canyinIsAllNew;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(Double contractPrice) {
        this.contractPrice = contractPrice;
    }

    public Integer getHidden() {
        return hidden;
    }

    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }

    public String getHiddenStr() {
        return hiddenStr;
    }

    public void setHiddenStr(String hiddenStr) {
        this.hiddenStr = hiddenStr;
    }

    public String getFirmIds() {
        return firmIds;
    }

    public void setFirmIds(String firmIds) {
        this.firmIds = firmIds;
    }

    public Integer getFirmCount() {
        return firmCount;
    }

    public void setFirmCount(Integer firmCount) {
        this.firmCount = firmCount;
    }

    public Integer getCanyinFirmCount() {
        return canyinFirmCount;
    }

    public void setCanyinFirmCount(Integer canyinFirmCount) {
        this.canyinFirmCount = canyinFirmCount;
    }

    public Integer getMovieFirmCount() {
        return movieFirmCount;
    }

    public void setMovieFirmCount(Integer movieFirmCount) {
        this.movieFirmCount = movieFirmCount;
    }

    public Integer getKtvFirmCount() {
        return ktvFirmCount;
    }

    public void setKtvFirmCount(Integer ktvFirmCount) {
        this.ktvFirmCount = ktvFirmCount;
    }

    public Integer getFirmCountOnly() {
        return firmCountOnly;
    }

    public void setFirmCountOnly(Integer firmCountOnly) {
        this.firmCountOnly = firmCountOnly;
    }

    public Integer getCanyinFirmCountOnly() {
        return canyinFirmCountOnly;
    }

    public void setCanyinFirmCountOnly(Integer canyinFirmCountOnly) {
        this.canyinFirmCountOnly = canyinFirmCountOnly;
    }

    public Integer getMovieFirmCountOnly() {
        return movieFirmCountOnly;
    }

    public void setMovieFirmCountOnly(Integer movieFirmCountOnly) {
        this.movieFirmCountOnly = movieFirmCountOnly;
    }

    public Integer getKtvFirmCountOnly() {
        return ktvFirmCountOnly;
    }

    public void setKtvFirmCountOnly(Integer ktvFirmCountOnly) {
        this.ktvFirmCountOnly = ktvFirmCountOnly;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public int getDdealId() {
        return ddealId;
    }

    public void setDdealId(int ddealId) {
        this.ddealId = ddealId;
    }

    public double getDongXiaoRate() {
        return dongXiaoRate;
    }

    public void setDongXiaoRate(double dongXiaoRate) {
        this.dongXiaoRate = dongXiaoRate;
    }

    public int getOnlineDealDx() {
        return onlineDealDx;
    }

    public void setOnlineDealDx(int onlineDealDx) {
        this.onlineDealDx = onlineDealDx;
    }

    public int getDxCount() {
        return dxCount;
    }

    public void setDxCount(int dxCount) {
        this.dxCount = dxCount;
    }

    public int getCustomId() {
        return customId;
    }

    public void setCustomId(int customId) {
        this.customId = customId;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public String getqGroup() {
        return qGroup;
    }

    public void setqGroup(String qGroup) {
        this.qGroup = qGroup;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public String getStatTotalMoneyByDay() {
        return statTotalMoneyByDay;
    }

    public void setStatTotalMoneyByDay(String statTotalMoneyByDay) {
        this.statTotalMoneyByDay = statTotalMoneyByDay;
    }

    public String getStatBuyCountByDay() {
        return statBuyCountByDay;
    }

    public void setStatBuyCountByDay(String statBuyCountByDay) {
        this.statBuyCountByDay = statBuyCountByDay;
    }

    public String getStatTotalMoneyPerfByDay() {
        return statTotalMoneyPerfByDay;
    }

    public void setStatTotalMoneyPerfByDay(String statTotalMoneyPerfByDay) {
        this.statTotalMoneyPerfByDay = statTotalMoneyPerfByDay;
    }

    public Integer getSevenRefund() {
        return sevenRefund;
    }

    public void setSevenRefund(Integer sevenRefund) {
        this.sevenRefund = sevenRefund;
    }

    public String getSevenRefundStr() {
        return sevenRefundStr;
    }

    public void setSevenRefundStr(String sevenRefundStr) {
        this.sevenRefundStr = sevenRefundStr;
    }

    public Integer getExpireRefund() {
        return expireRefund;
    }

    public void setExpireRefund(Integer expireRefund) {
        this.expireRefund = expireRefund;
    }

    public String getExpireRefundStr() {
        return expireRefundStr;
    }

    public void setExpireRefundStr(String expireRefundStr) {
        this.expireRefundStr = expireRefundStr;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public Integer getIsElong() {
        return isElong;
    }

    public void setIsElong(Integer isElong) {
        this.isElong = isElong;
    }

    public String getIsElongStr() {
        return isElongStr;
    }

    public void setIsElongStr(String isElongStr) {
        this.isElongStr = isElongStr;
    }

    public String getNeedSendStr() {
        return needSendStr;
    }

    public void setNeedSendStr(String needSendStr) {
        this.needSendStr = needSendStr;
    }

    public Integer getIsSelfService() {
        return isSelfService;
    }

    public void setIsSelfService(Integer isSelfService) {
        this.isSelfService = isSelfService;
    }

    public String getIsSelfServiceStr() {
        return isSelfServiceStr;
    }

    public void setIsSelfServiceStr(String isSelfServiceStr) {
        this.isSelfServiceStr = isSelfServiceStr;
    }

    public Integer getIsZero() {
        return isZero;
    }

    public void setIsZero(Integer isZero) {
        this.isZero = isZero;
    }

    public String getIsZeroStr() {
        return isZeroStr;
    }

    public void setIsZeroStr(String isZeroStr) {
        this.isZeroStr = isZeroStr;
    }

    public Integer getOtherSiteCode() {
        return otherSiteCode;
    }

    public void setOtherSiteCode(Integer otherSiteCode) {
        this.otherSiteCode = otherSiteCode;
    }

    public String getOtherSiteCodeStr() {
        return otherSiteCodeStr;
    }

    public void setOtherSiteCodeStr(String otherSiteCodeStr) {
        this.otherSiteCodeStr = otherSiteCodeStr;
    }

    public Integer getIsTwoDim() {
        return isTwoDim;
    }

    public void setIsTwoDim(Integer isTwoDim) {
        this.isTwoDim = isTwoDim;
    }

    public String getIsTwoDimStr() {
        return isTwoDimStr;
    }

    public void setIsTwoDimStr(String isTwoDimStr) {
        this.isTwoDimStr = isTwoDimStr;
    }

    public Integer getIsLocal() {
        return isLocal;
    }

    public void setIsLocal(Integer isLocal) {
        this.isLocal = isLocal;
    }

    public String getIsLocalStr() {
        return isLocalStr;
    }

    public void setIsLocalStr(String isLocalStr) {
        this.isLocalStr = isLocalStr;
    }

    public Integer getIsSouzhe() {
        return isSouzhe;
    }

    public void setIsSouzhe(Integer isSouzhe) {
        this.isSouzhe = isSouzhe;
    }

    public String getIsSouzheStr() {
        return isSouzheStr;
    }

    public void setIsSouzheStr(String isSouzheStr) {
        this.isSouzheStr = isSouzheStr;
    }

    public String getIsAllNewStr() {
        return isAllNewStr;
    }

    public void setIsAllNewStr(String isAllNewStr) {
        this.isAllNewStr = isAllNewStr;
    }

    public Integer getCertiCancelCount() {
        return certiCancelCount;
    }

    public void setCertiCancelCount(Integer certiCancelCount) {
        this.certiCancelCount = certiCancelCount;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getOldFirmName() {
        return oldFirmName;
    }

    public void setOldFirmName(String oldFirmName) {
        this.oldFirmName = oldFirmName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public Long getPv() {
        return pv;
    }

    public void setPv(Long pv) {
        this.pv = pv;
    }

    public Long getUv() {
        return uv;
    }

    public void setUv(Long uv) {
        this.uv = uv;
    }

    public Long getVisit() {
        return visit;
    }

    public void setVisit(Long visit) {
        this.visit = visit;
    }

}

