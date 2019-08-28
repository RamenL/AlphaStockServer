package com.alpha.ranen.models;

import com.fasterxml.jackson.annotation.JsonProperty;


public class GlobalTemp {
    @JsonProperty("Global Quote")
    private GlobalQuote globalQuote;

    public GlobalQuote getGlobalQuote(){
        return this.globalQuote;
    }

    public void setGlobalQuote(GlobalQuote globalQuote){
        this.globalQuote = globalQuote;
    }

}
