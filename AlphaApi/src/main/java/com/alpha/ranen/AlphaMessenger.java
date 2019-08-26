package com.alpha.ranen;

import io.restassured.response.Response;

public class AlphaMessenger {

    public static void checkResponseStatus(Response response){
        if(response.getStatusCode() != 200){
            //TODO throw error
        }
    }

    public static void errorMessage(){
        //TODO map with error messages
    }

    public static String displayCurrentTicker(){
        String ticker = RecentSingleton.getRecentSingleton().getTicker();
        return "The current ticker is " + ticker + ".";
    }

}
