package com.alpha.ranen.controllers;

import com.alpha.ranen.RecentSingleton;
import com.alpha.ranen.models.TimeSeries;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class RootController {
    private RecentSingleton recentSingleton;

    public RootController(){
        recentSingleton = RecentSingleton.getRecentSingleton();
    }

    @GetMapping("/")
    public String home(){
        return recentSingleton.getTicker();
    }

    @GetMapping("/recent")
    public String recentTimeSeries(){
        TimeSeries timeSeries = RecentSingleton.getRecentSingleton().getRecentTimeSeries();
        if(timeSeries == null){
            return "empty";
        }
        return timeSeries.getHigh();
    }

    @RequestMapping(path = "/", method = RequestMethod.PATCH)
    public String change(@RequestHeader Map<String, String> headers){
        String updateTicker = headers.get("ticker");
        RecentSingleton.getRecentSingleton().setTicker(updateTicker);
        return "Ticker update to the following: " + updateTicker;
    }


}
