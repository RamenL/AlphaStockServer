package com.alpha.ranen.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class GlobalQuote {
    private String symbol;
    private String open;
    private String high;
    private String low;
    private String price;
    private String volume;
    private String latestTradingDay;
    private String previousClose;
    private String change;
    private String changePercent;

    @JsonGetter("01. symbol")
    public String getSymbol() {
        return symbol;
    }

    @JsonSetter("01. symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @JsonGetter("02. open")
    public String getOpen() {
        return open;
    }

    @JsonSetter("02. open")
    public void setOpen(String open) {
        this.open = open;
    }

    @JsonGetter("03. high")
    public String getHigh() {
        return high;
    }

    @JsonSetter("03. high")
    public void setHigh(String high) {
        this.high = high;
    }

    @JsonGetter("04. low")
    public String getLow() {
        return low;
    }

    @JsonSetter("04. low")
    public void setLow(String low) {
        this.low = low;
    }

    @JsonGetter("05. price")
    public String getPrice() {
        return price;
    }

    @JsonSetter("05. price")
    public void setPrice(String price) {
        this.price = price;
    }

    @JsonGetter("06. volume")
    public String getVolume() {
        return volume;
    }

    @JsonSetter("06. volume")
    public void setVolume(String volume) {
        this.volume = volume;
    }

    @JsonGetter("07. latest trading day")
    public String getLatestTradingDay() {
        return latestTradingDay;
    }

    @JsonSetter("07. latest trading day")
    public void setLatestTradingDay(String latestTradingDay) {
        this.latestTradingDay = latestTradingDay;
    }

    @JsonGetter("08. previous close")
    public String getPreviousClose() {
        return previousClose;
    }

    @JsonSetter("08. previous close")
    public void setPreviousClose(String previousClose) {
        this.previousClose = previousClose;
    }

    @JsonGetter("09. change")
    public String getChange() {
        return change;
    }

    @JsonSetter("09. change")
    public void setChange(String change) {
        this.change = change;
    }

    @JsonGetter("10. change percent")
    public String getChangePercent() {
        return changePercent;
    }

    @JsonSetter("10. change percent")
    public void setChangePercent(String changePercent) {
        this.changePercent = changePercent;
    }

}
