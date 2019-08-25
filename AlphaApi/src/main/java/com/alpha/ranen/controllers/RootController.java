package com.alpha.ranen.controllers;

import com.alpha.ranen.RecentSingleton;
import com.alpha.ranen.models.TimeSeries;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RootController {
    private RecentSingleton recentSingleton;

    public RootController(){
        recentSingleton = RecentSingleton.getRecentSingleton();
    }

    @GetMapping("/recent")
    public String recentTimeSeries(){
        TimeSeries timeSeries = RecentSingleton.getRecentSingleton().getRecentTimeSeries();
        if(timeSeries == null){
            return "empty";
        }
        return timeSeries.getHigh();
    }

    @GetMapping("/")
    public String home(){
        return recentSingleton.getTicker();
    }
}
