package com.example.rewards;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public final class RewardHandler {
    public static final String DateAndTime = "currentDate";
    public static final String Counts = "counts";

//    private static DataRepository dataRepository;
    private static String prevDateTime;
    private static int countNoOfDays;
    private static Context context;
    private static int firstDayCoin = 10;

    private static String TAG = "CHECK";

    public static void streakReward() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
//        dataRepository = PaperDataRepo.getInstance(context);

        try {

            prevDateTime = format.format(new Date());  //check for first boot up time, stored locally

            if (prevDateTime != null) {

//                countNoOfDays = Integer.parseInt(dataRepository.getAppDaysCount());
                String currentDateAndTime = format.format(new Date());
                long dayDifference = dateDifference(prevDateTime, currentDateAndTime);

                if (dayDifference == 1) {
                    countNoOfDays++;
                    int coin = 10 * countNoOfDays;

                    Log.d(TAG, "Streak Reward for " + countNoOfDays + " day: " + coin + "coins");
//
//                    dataRepository.saveCurrentDateTime(currentDateAndTime, Integer.toString(countNoOfDays));

                } else if (dayDifference >= 1) {


                    Log.d(TAG, "Streak Reward for 1st day: " + 10 + "coins");

//                    dataRepository.saveCurrentDateTime(currentDateAndTime, Integer.toString(1));

                } else {
//                    dataRepository.saveCurrentDateTime(currentDateAndTime, Integer.toString(countNoOfDays));
                }

            } else {
                String currentDateAndTime = format.format(new Date());
//                String currentDateAndTime = "2020-01-25 12:32:22"; //testing
//                dataRepository.saveCurrentDateTime(currentDateAndTime, Integer.toString(1));
                Log.d(TAG, "Streak Reward for 1st day: " + 10 + "coins");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private static long dateDifference(String previousDate, String currentDate) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(previousDate);
            d2 = format.parse(currentDate);

            long diff = d2.getTime() - d1.getTime();

//           long diffSeconds = diff / 1000 % 60;
//           long diffMinutes = diff / (60 * 1000) % 60;
//           long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            return diffDays;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }



}



