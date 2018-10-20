package io.fintel.iex.model;

import java.math.BigDecimal;

public class StockChartItem {

    private String date;
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;
    private BigDecimal volume;
    private BigDecimal unadjustedVolume;
    private BigDecimal change;
    private BigDecimal changePercent;
    private BigDecimal vwap;
    private String label;
    private BigDecimal changeOverTime;

    public BigDecimal getChange() {
        return change;
    }

    public BigDecimal getChangeOverTime() {
        return changeOverTime;
    }

    public BigDecimal getChangePercent() {
        return changePercent;
    }

    public BigDecimal getClose() {
        return close;
    }

    public String getDate() {
        return date;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public String getLabel() {
        return label;
    }

    public BigDecimal getLow() {
        return low;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public BigDecimal getUnadjustedVolume() {
        return unadjustedVolume;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public BigDecimal getVwap() {
        return vwap;
    }

    public void setChange(BigDecimal change) {
        this.change = change;
    }

    public void setChangeOverTime(BigDecimal changeOverTime) {
        this.changeOverTime = changeOverTime;
    }

    public void setChangePercent(BigDecimal changePercent) {
        this.changePercent = changePercent;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public void setUnadjustedVolume(BigDecimal unadjustedVolume) {
        this.unadjustedVolume = unadjustedVolume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public void setVwap(BigDecimal vwap) {
        this.vwap = vwap;
    }
}
