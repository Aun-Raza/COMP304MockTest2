package com.example.aunraza_comp304_sec005_finalterm_practice;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "stockInfo")
public class StockInfo {
    @NonNull
    @PrimaryKey
    private String stockSymbol;
    private String companyName;
    private double stockQuote;

    public StockInfo(@NonNull String stockSymbol, String companyName, double stockQuote) {
        this.stockSymbol = stockSymbol;
        this.companyName = companyName;
        this.stockQuote = stockQuote;
    }

    @NonNull
    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(@NonNull String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getStockQuote() {
        return stockQuote;
    }

    public void setStockQuote(double stockQuote) {
        this.stockQuote = stockQuote;
    }
}
