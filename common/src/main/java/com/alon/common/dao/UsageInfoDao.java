package com.alon.common.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.alon.common.models.UsageInfo;

import java.util.List;

@Dao
public interface UsageInfoDao {

    @Insert
    void insertAll(UsageInfo... usageInfos);

    @Query("SELECT * FROM usage_info")
    List<UsageInfo> getAll();
}
