package com.alpha.ranen;

import com.alpha.ranen.models.TimeSeries;
import com.alpha.ranen.models.TimeSeriesMap;

public class RecentSingleton {

    private static RecentSingleton recentSingleton = new RecentSingleton(); //eager initialization
    private TimeSeriesMap timeSeriesMap;
    private String ticker;

    private RecentSingleton(){

    }

    public static RecentSingleton getRecentSingleton() {
        return recentSingleton;
    }

    public TimeSeriesMap setTimeSeriesMap(TimeSeriesMap timeSeriesMap) {
        this.timeSeriesMap = timeSeriesMap;
        return this.timeSeriesMap;
    }

    public TimeSeriesMap getTimeSeriesMap(){
        return this.timeSeriesMap;
    }

    public TimeSeries getRecentTimeSeries(){
        if(this.timeSeriesMap == null || this.timeSeriesMap.isEmpty()){
            return null;
        }
        return this.timeSeriesMap.values().stream().findFirst().orElse(null);
    }

    public String setTicker(String ticker){
        this.ticker = ticker;
        return this.ticker;
    }

    public String getTicker(){
        return this.ticker;
    }
}
