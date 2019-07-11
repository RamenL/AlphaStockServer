import io.restassured.response.*;
import models.*;

public class AlphaApi{

    private AlphaClient alphaClient;
    private String ticker;


    public static void main(String[] args){
        new AlphaApi("MSFT", "HK1DZ9TZBDHG0OE1");
    }

    public AlphaApi(String ticker, String apiKey){
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
