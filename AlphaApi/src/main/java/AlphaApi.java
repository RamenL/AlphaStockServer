import io.restassured.response.*;
import models.*;

public class AlphaApi{

    private AlphaClient alphaClient;
    private String ticker;


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
        run();
    }

    public void run(){
        Response response = this.alphaClient.alphaStock(this.ticker);
        StockWrapper stockWrapper = response.as(StockWrapper.class);
        TimeSeriesMap timeSeriesMap = stockWrapper.getTimeSeriesWrapper();
        for(String current : timeSeriesMap.keySet()){
            System.out.println(current);
        }
    }

}
