import io.restassured.response.*;
import models.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.Executors;


public class AlphaApi /*implements Runnable*/{

    private AlphaClient alphaClient;
    private Map<String, TimeSeries> timeSeriesMap;
    private String ticker;


    public static void main(String[] args){
        new AlphaApi("MSFT", "HK1DZ9TZBDHG0OE1");
    }

    public AlphaApi(String ticker, String apiKey){
        this.ticker = ticker;
        AlphaClient alphaClient = new AlphaClient(apiKey);
        timeSeriesMap = new ConcurrentHashMap<String, TimeSeries>();
        //Executors.newSingleThreadExecutor().submit(this);
        run();
    }

    public void run(){
        Response response = alphaClient.alphaStock(this.ticker);
        StockWrapper stockWrapper = response.as(StockWrapper.class);
        TimeSeriesMap timeSeriesMap = stockWrapper.getTimeSeriesWrapper();
        this.timeSeriesMap.putAll(timeSeriesMap);
        for(String current : this.timeSeriesMap.keySet()){
            System.out.println(current);
        }
        /*try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

}
