package models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class TimeSeriesMap extends HashMap<String, TimeSeries> {

    @JsonAnyGetter
    public Map<String, TimeSeries> getTimeSeriesMap(){
        return this;
    }

    @JsonAnySetter
    public void setTimeSeriesMap(HashMap<String, TimeSeries> map){
        this.putAll(map);
    }

}
