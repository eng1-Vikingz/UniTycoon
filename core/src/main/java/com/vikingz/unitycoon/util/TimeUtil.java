package com.vikingz.unitycoon.util;

public class TimeUtil {
    

    class Time{

        public int secs;
        public int mins;
        public int hrs;

        public Time(int secs, int mins, int hrs){
            this.secs = secs;
            this.mins = mins;
            this.hrs = hrs;
        }

    }

    public Time secondsToTime(int secs){
        return new Time(secs, secs, secs);
        
        
    }

}
