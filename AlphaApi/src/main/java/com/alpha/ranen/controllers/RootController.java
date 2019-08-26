package com.alpha.ranen.controllers;

import com.alpha.ranen.AlphaMessenger;
import com.alpha.ranen.RecentSingleton;
import com.alpha.ranen.models.TimeSeries;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class RootController {
    private static final String TICKER_HEADER = "ticker";
    private RecentSingleton recentSingleton;

    public RootController(){
        recentSingleton = RecentSingleton.getRecentSingleton();
    }

    @GetMapping("/")
    public String home(){
        return AlphaMessenger.displayCurrentTicker();
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
    public String patchHandler(@RequestHeader Map<String, String> headers){
        if(headers.containsKey(TICKER_HEADER)){
            return updateTicker(headers.get(TICKER_HEADER));
        }
        return "";
    }

    public String updateTicker(String updateTicker){
        RecentSingleton.getRecentSingleton().setTicker(updateTicker);
        return AlphaMessenger.displayCurrentTicker();
    }


}
