package com.alpha.ranen;


import com.alpha.ranen.controllers.StockController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.Executors;

@SpringBootApplication
public class AlphaSpringApplication {

    public static void main(String[] args){
        Executors.newSingleThreadExecutor().submit(new StockController());
        SpringApplication.run(AlphaSpringApplication.class, args);
    }
}
