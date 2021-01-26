package com.alon.common;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UsageInfo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UsageInfoDao usageInfoDao();
}
