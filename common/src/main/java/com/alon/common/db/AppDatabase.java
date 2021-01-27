package com.alon.common.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.alon.common.dao.UsageInfoDao;
import com.alon.common.models.UsageInfo;

@Database(entities = {UsageInfo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UsageInfoDao usageInfoDao();
}
