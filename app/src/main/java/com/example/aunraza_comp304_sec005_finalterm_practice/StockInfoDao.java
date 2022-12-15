package com.example.aunraza_comp304_sec005_finalterm_practice;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StockInfoDao {
    @Insert
    void insertStockInfo(StockInfo stockInfo);

    @Query("SELECT * FROM stockInfo")
    LiveData<List<StockInfo>> getAllStockInfo();

    @Query("SELECT * FROM stockInfo WHERE stockSymbol = :stockSymbol")
    StockInfo getStockInfo(String stockSymbol);
}
