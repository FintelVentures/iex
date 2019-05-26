package io.fintel.iex.model;

import java.util.Objects;
import java.util.StringJoiner;

public class Symbol {

    private String symbol;
    private String exchange;
    private String name;
    private String date;
    private boolean isEnabled;
    private String type;
    private String region;
    private String currency;
    private String iexId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol = (Symbol) o;
        return iexId == symbol.iexId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(iexId);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Symbol.class.getSimpleName() + "[", "]")
                .add("symbol='" + symbol + "'")
                .add("name='" + name + "'")
                .add("date='" + date + "'")
                .add("isEnabled=" + isEnabled)
                .add("type='" + type + "'")
                .add("iexId=" + iexId)
                .toString();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getIexId() {
        return iexId;
    }

    public void setIexId(String iexId) {
        this.iexId = iexId;
    }
}
