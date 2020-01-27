package com.example.rewards;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RewardHandler {

    private  String TAG  = "Testing";


    public void DayChecker() {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String currentDateAndTime = format.format(new Date());


        Log.d(TAG,"Current time:\t"+currentDateAndTime);

        ///need to repalce with sys date...
        //save in shared prefecnce


        String dateStart = "2020-01-27 15:01:55";
        String dateStop = "2020-01-30 5:23:05";

        long check = FindDifference(dateStart,dateStop);

        Log.d(TAG,"Day:\t"+check);


    }




   private static long FindDifference(String previousDate, String currentDate){

       //HH converts hour in 24 hours format (0-23), day calculation
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


