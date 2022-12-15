package com.example.aunraza_comp304_sec005_finalterm_practice;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class StockInfoRepository {
    private LiveData<List<StockInfo>> allStockInfo;
    private StockInfoDao stockInfoDao;

    public StockInfoRepository(Application application) {
        StockInfoRoomDatabase db = StockInfoRoomDatabase.getDatabase(application);
        stockInfoDao = db.StockInfoDao();
        allStockInfo = stockInfoDao.getAllStockInfo();
    }

    public LiveData<List<StockInfo>> getAllStockInfo() { return allStockInfo; }

    public void insertStockInfo(StockInfo stockInfo) {
        new insertStockInfoAsyncTask(stockInfoDao).execute(stockInfo);
    }

    public StockInfo getStockInfo(String stockSymbol) {
        try {
            return new getStockInfoAsyncTask(stockInfoDao).execute(stockSymbol).get();
        } catch (Exception ex) {
            return null;
        }
    }

    private static class insertStockInfoAsyncTask extends AsyncTask<StockInfo, Void, Void> {
        StockInfoDao stockInfoDao;

        public insertStockInfoAsyncTask(StockInfoDao dao) {
            stockInfoDao = dao;
        }

        @Override
        protected Void doInBackground(StockInfo... stockInfo) {
            stockInfoDao.insertStockInfo(stockInfo[0]);
            return null;
        }
    }

    private static class getStockInfoAsyncTask extends AsyncTask<String, Void, StockInfo> {
        StockInfoDao stockInfoDao;

        public getStockInfoAsyncTask(StockInfoDao dao) {
            stockInfoDao = dao;
        }

        @Override
        protected StockInfo doInBackground(String... params) {
            StockInfo stockInfo = stockInfoDao.getStockInfo(params[0]);
            return stockInfo;
        }
    }
}
