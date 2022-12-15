package com.example.aunraza_comp304_sec005_finalterm_practice;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {StockInfo.class}, version = 1)
public abstract class StockInfoRoomDatabase extends RoomDatabase {
    public abstract StockInfoDao StockInfoDao();
    private static StockInfoRoomDatabase INSTANCE;

    static StockInfoRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (StockInfoRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    StockInfoRoomDatabase.class,
                                    "StockInfoDB")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
