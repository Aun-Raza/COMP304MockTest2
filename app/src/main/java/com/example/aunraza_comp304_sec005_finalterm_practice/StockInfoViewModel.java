package com.example.aunraza_comp304_sec005_finalterm_practice;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class StockInfoViewModel extends AndroidViewModel {
    private LiveData<List<StockInfo>> allStockInfo;
    private StockInfoRepository repository;

    public StockInfoViewModel(@NonNull Application application) {
        super(application);
        repository = new StockInfoRepository(application);
        allStockInfo = repository.getAllStockInfo();
    }

    public void insertStockInfo(StockInfo stockInfo) {
        repository.insertStockInfo(stockInfo);
    }

    public StockInfo getStockInfo(String stockSymbol) {
        return repository.getStockInfo(stockSymbol);
    }

    public LiveData<List<StockInfo>> getAllStockInfo() {
        return allStockInfo;
    }
}
