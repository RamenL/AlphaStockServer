import io.restassured.response.*;
import models.*;

import java.util.concurrent.Executors;

public class AlphaApi implements Runnable{

    private AlphaClient alphaClient;
    private String ticker;

    private final int MILLISECONDS = 1000;
    private final int SECONDS_TO_WAIT = 5;


    public static void main(String[] args){
        if(args.length != 2){
            System.err.println("Usage: " + AlphaApi.class.getName() + " apiKey ticker");
            System.exit(-1);
        }
        String apiKey = args[0];
        String ticker = args[1];
        new AlphaApi(apiKey, ticker);
    }

    public AlphaApi(String apiKey, String ticker){
        this.ticker = ticker;
        this.alphaClient = new AlphaClient(apiKey);
        Executors.newSingleThreadExecutor().submit(this);
    }

    public void run(){
        try{
            for(int i = 0; i < 5; i++){
                Response response = this.alphaClient.alphaStock(this.ticker);
                StockWrapper stockWrapper = response.as(StockWrapper.class);
                TimeSeriesMap timeSeriesMap = stockWrapper.getTimeSeriesWrapper();
                System.out.println(ticker + " Intraday content");
                timeSeriesMap.keySet().forEach(stock -> System.out.println(stock));
                sleepInMinutes(SECONDS_TO_WAIT);

            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void sleepInMinutes(int minutes){
        try{
            Thread.sleep(minutes * MILLISECONDS);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Thread Interrupted");
        }
    }

}
