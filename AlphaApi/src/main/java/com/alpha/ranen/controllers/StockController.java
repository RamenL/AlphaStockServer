package com.alpha.ranen.controllers;

import com.alpha.ranen.AlphaClient;
import com.alpha.ranen.models.*;
import com.google.gson.JsonObject;
import com.intellij.icons.AllIcons;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;


@Controller
public class StockController {
    private AlphaClient alphaClient;


    public StockController(){
        super();
        this.alphaClient = new AlphaClient("HK1DZ9TZBDHG0OE1");
    }

    @GetMapping
    public String home(){
        String stock = "";
        Response response = this.alphaClient.alphaStock("MSFT");
        StockWrapper stockWrapper = response.as(StockWrapper.class);
        TimeSeriesMap timeSeriesMap = stockWrapper.getTimeSeriesWrapper();
        Map<String, String> jsonMap = new HashMap<>();
        for(String current : timeSeriesMap.keySet()){
            jsonMap.put(current, timeSeriesMap.get(current).getHigh());
        }

        return stock;
    }
}
