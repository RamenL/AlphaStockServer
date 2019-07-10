import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.*;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class AlphaClient {

    private String apikey;

    public AlphaClient(String apikey){
        this.apikey = apikey;
    }

    public Response alphaStock(String symbol){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://www.alphavantage.co");
        RequestSpecification requestSpecification = requestSpecBuilder.build();
        return given().spec(requestSpecification).param("function", "TIME_SERIES_INTRADAY").param("symbol", symbol).param("interval", "5min").param("apikey", apikey).get("query").andReturn();
    }
}
