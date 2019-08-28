package com.alpha.ranen.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class TimeSeries {
    private String open;
    private String high;
    private String low;
    private String close;
    private String volume;

    @JsonGetter("1. open")
    public String getOpen() {
        return open;
    }

    @JsonSetter("1. open")
    public void setOpen(String open) {
        this.open = open;
    }

    @JsonGetter("2. high")
    public String getHigh() {
        return high;
    }

    @JsonSetter("2. high")
    public void setHigh(String high) {
        this.high = high;
    }

    @JsonGetter("3. low")
    public String getLow() {
        return low;
    }

    @JsonSetter("3. low")
    public void setLow(String low) {
        this.low = low;
    }

    @JsonGetter("4. close")
    public String getClose() {
        return close;
    }

    @JsonSetter("4. close")
    public void setClose(String close) {
        this.close = close;
    }

    @JsonGetter("5. volume")
    public String getVolume() {
        return volume;
    }

    @JsonSetter("5. volume")
    public void setVolume(String volume) {
        this.volume = volume;
    }

}
