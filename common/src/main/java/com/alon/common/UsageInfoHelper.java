package com.alon.common;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class UsageInfoHelper {
    private static UsageInfoHelper instance;
    private static AppDatabase appDatabase;

    public UsageInfoHelper(Context context) {
        appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "UsageInfo.db").build();
    }

    public static UsageInfoHelper getInstance() {
        return instance;
    }

    public static UsageInfoHelper initHelper(Context context) {
        if (instance == null) {
            instance = new UsageInfoHelper(context);
        }
        return instance;
    }

    public interface Callback_UsageInfo {
        void dataReady(String usageTime);
    }

    public void addUsageInfo(String startTime, String endTime, long usageTime) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                appDatabase.usageInfoDao().insertAll(new UsageInfo(startTime, endTime, usageTime));
            }
        }).start();
    }

    public void getAllUsageInfo(Callback_UsageInfo callback_usageInfo) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<UsageInfo> usageInfoList = appDatabase.usageInfoDao().getAll();
                long usageTime = 0;
                StringBuilder sb = new StringBuilder();
                for (UsageInfo usageInfo : usageInfoList) {
                    usageTime += usageInfo.getUsageTime();
                    Log.d("pttt", usageInfo.getId() + " - " + usageInfo.getStartTime() + " - " + usageInfo.getEndTime() + " - " + Long.valueOf(usageInfo.getUsageTime()).toString());
                }
                if (usageTime > 0) {
                    long hours = TimeUnit.MILLISECONDS.toHours(usageTime) % 24;
                    usageTime -= TimeUnit.HOURS.toMillis(hours);
                    long minutes = TimeUnit.MILLISECONDS.toMinutes(usageTime) % 60;
                    usageTime -= TimeUnit.MINUTES.toMillis(minutes);
                    long seconds = TimeUnit.MILLISECONDS.toSeconds(usageTime) % 60;
                    sb.append(hours);
                    sb.append(":");
                    sb.append(minutes);
                    sb.append(":");
                    sb.append(seconds);
                }
                if (callback_usageInfo != null) {
                    callback_usageInfo.dataReady(sb.toString());
                }
            }
        }).start();
    }
}
