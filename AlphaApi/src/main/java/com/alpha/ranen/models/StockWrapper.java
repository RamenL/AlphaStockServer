package com.alpha.ranen.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class StockWrapper {
    private MetaData metaData;
    private TimeSeriesMap timeSeriesWrapper;

    @JsonGetter("Meta Data")
    public MetaData getMetaData() {
        return metaData;
    }

    @JsonSetter("Meta Data")
    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    @JsonGetter("Time Series (5min)")
    public TimeSeriesMap getTimeSeriesWrapper(){
        return this.timeSeriesWrapper;
    }

    @JsonSetter("Time Series (5min)")
    public void setTimeSeriesWrapper(TimeSeriesMap timeSeriesWrapper){
        this.timeSeriesWrapper = timeSeriesWrapper;
    }

}
