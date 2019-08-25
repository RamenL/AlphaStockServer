package com.alpha.ranen;

import com.alpha.ranen.models.TimeSeries;
import com.alpha.ranen.models.TimeSeriesMap;

public class RecentSingleton {

    private RecentSingleton recentSingleton = new RecentSingleton();
    private TimeSeriesMap timeSeriesMap;

    private RecentSingleton(){

    }

    public RecentSingleton getRecentSingleton() {
        return this.recentSingleton;
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
}
