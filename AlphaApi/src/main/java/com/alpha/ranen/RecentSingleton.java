package com.alpha.ranen;

import com.alpha.ranen.models.MetaData;
import com.alpha.ranen.models.TimeSeries;
import com.alpha.ranen.models.TimeSeriesMap;

public class RecentSingleton {

    private static RecentSingleton recentSingleton; //eager initialization
    private static TimeSeriesMap timeSeriesMap;
    private static MetaData metaData;
    private static String ticker = "MSFT";

    private RecentSingleton(){

    }

    public static synchronized RecentSingleton getRecentSingleton() {
        if(recentSingleton == null){
            return new RecentSingleton();
        }
        return recentSingleton;
    }

    public static TimeSeriesMap setTimeSeriesMap(TimeSeriesMap newTimeSeriesMap) {
        timeSeriesMap = newTimeSeriesMap;
        return timeSeriesMap;
    }

    public static TimeSeriesMap getTimeSeriesMap(){
        return timeSeriesMap;
    }

    public static TimeSeries getRecentTimeSeries(){
        if(timeSeriesMap == null || timeSeriesMap.isEmpty()){
            return null;
        }
        return timeSeriesMap.values().stream().findFirst().orElse(null);
    }

    public String setTicker(String newTicker){
        ticker = newTicker;
        return ticker;
    }

    public static String getTicker(){
        return ticker;
    }

    public static MetaData setMetaData(MetaData data){
        metaData = data;
        return metaData;
    }

    public static MetaData getMetaData(){
        return metaData;
    }
}
