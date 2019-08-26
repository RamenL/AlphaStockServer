package com.alpha.ranen.controllers;

import com.alpha.ranen.AlphaClient;
import com.alpha.ranen.AlphaMessenger;
import com.alpha.ranen.RecentSingleton;
import com.alpha.ranen.models.*;
import io.restassured.response.Response;

public class StockController implements Runnable{
    private AlphaClient alphaClient;
    private final int FIVE_MIN = 300000;

//    public StockController(){
//        super();
//        this.alphaClient = new AlphaClient("HK1DZ9TZBDHG0OE1");
//    }

    public void run(){
        this.alphaClient = new AlphaClient("HK1DZ9TZBDHG0OE1");
        for(;;){
            Response response = this.alphaClient.alphaStock(RecentSingleton.getRecentSingleton().getTicker());
            AlphaMessenger.checkResponseStatus(response);
            StockWrapper stockWrapper = response.as(StockWrapper.class);
            TimeSeriesMap timeSeriesMap = stockWrapper.getTimeSeriesWrapper();
            RecentSingleton.getRecentSingleton().setTimeSeriesMap(timeSeriesMap);
            sleep();
        }
    }

    private void sleep(){
        try{
            Thread.sleep(FIVE_MIN);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
