package com.alon.common;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "usage_info")
public class UsageInfo {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "start_time")
    private String startTime;

    @ColumnInfo(name = "end_time")
    private String endTime;

    @ColumnInfo(name = "usage_time")
    private long usageTime;

    // Constructors
    public UsageInfo() {
    }

    public UsageInfo(String startTime, String endTime, long usageTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.usageTime = usageTime;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public long getUsageTime() {
        return usageTime;
    }

    public void setUsageTime(long usageTime) {
        this.usageTime = usageTime;
    }
}
