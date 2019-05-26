package io.fintel.iex.model;

public class ShortInterestItem {

    private String settlementDate;
    private String securityName;
    private Integer currentShortInterest;
    private Integer previousShortInterest;
    private Double percentChange;
    private Integer averageDailyVolume;
    private Double daysToCover;
    private String stockAdjustmentFlag;
    private String revisionFlag;
    private String symbolinINETSymbology;
    private String symbolinCQSSymbology;
    private String symbolinCMSSymbology;
    private String newIssueFlag;
    private String companyName;


    public String getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate;
    }

    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }

    public Integer getCurrentShortInterest() {
        return currentShortInterest;
    }

    public void setCurrentShortInterest(Integer currentShortInterest) {
        this.currentShortInterest = currentShortInterest;
    }

    public Integer getPreviousShortInterest() {
        return previousShortInterest;
    }

    public void setPreviousShortInterest(Integer previousShortInterest) {
        this.previousShortInterest = previousShortInterest;
    }

    public Double getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(Double percentChange) {
        this.percentChange = percentChange;
    }

    public Integer getAverageDailyVolume() {
        return averageDailyVolume;
    }

    public void setAverageDailyVolume(Integer averageDailyVolume) {
        this.averageDailyVolume = averageDailyVolume;
    }

    public Double getDaysToCover() {
        return daysToCover;
    }

    public void setDaysToCover(Double daysToCover) {
        this.daysToCover = daysToCover;
    }

    public String getStockAdjustmentFlag() {
        return stockAdjustmentFlag;
    }

    public void setStockAdjustmentFlag(String stockAdjustmentFlag) {
        this.stockAdjustmentFlag = stockAdjustmentFlag;
    }

    public String getRevisionFlag() {
        return revisionFlag;
    }

    public void setRevisionFlag(String revisionFlag) {
        this.revisionFlag = revisionFlag;
    }

    public String getSymbolinINETSymbology() {
        return symbolinINETSymbology;
    }

    public void setSymbolinINETSymbology(String symbolinINETSymbology) {
        this.symbolinINETSymbology = symbolinINETSymbology;
    }

    public String getSymbolinCMSSymbology() {
        return symbolinCMSSymbology;
    }

    public void setSymbolinCMSSymbology(String symbolinCMSSymbology) {
        this.symbolinCMSSymbology = symbolinCMSSymbology;
    }

    public String getNewIssueFlag() {
        return newIssueFlag;
    }

    public void setNewIssueFlag(String newIssueFlag) {
        this.newIssueFlag = newIssueFlag;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSymbolinCQSSymbology() {
        return symbolinCQSSymbology;
    }

    public void setSymbolinCQSSymbology(String symbolinCQSSymbology) {
        this.symbolinCQSSymbology = symbolinCQSSymbology;
    }
}
