/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amlehstation.massenger;

/**
 *
 * @author msamalq
 */
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class DSCHEDULE {
    public String[] convertToQuarterHours(String[] workingHours) {
        ArrayList<String> quarterHoursList = new ArrayList<String>();
        for (int i = 0; i < workingHours.length; i += 2) {
            String day = workingHours[i];
            String[] startHourParts = workingHours[i + 1].split(":");
            int startHour = Integer.parseInt(startHourParts[0]);
            int startMinute = Integer.parseInt(startHourParts[1].split("-")[0]);
            String[] endHourParts = workingHours[i + 1].split("-")[1].split(":");
            int endHour = Integer.parseInt(endHourParts[0]);
            int endMinute = Integer.parseInt(endHourParts[1]);
            for (int hour = startHour; hour <= endHour; hour++) {
                for (int minute = 0; minute < 60; minute += 15) {
                    if (hour == startHour && minute < startMinute) {
                        continue;
                    }
                    if (hour == endHour && minute > endMinute) {
                        continue;
                    }
                    quarterHoursList.add(day);
                    String hourString = (hour < 10) ? "0" + hour : "" + hour;
                    String minuteString = (minute < 10) ? "0" + minute : "" + minute;
                    quarterHoursList.add(hourString + ":" + minuteString);
                }
            }
        }
        return quarterHoursList.toArray(new String[quarterHoursList.size()]);
    }
}
