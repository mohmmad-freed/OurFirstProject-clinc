/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amlehstation.massenger;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author ASD
 */
public class TimeConvert {
    public String TimeConverter12_24(String H12) {
        String timeString = H12;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh a", Locale.ENGLISH);
        LocalTime time = LocalTime.parse(timeString, formatter);
        String time24hr = time.format(DateTimeFormatter.ofPattern("HH"));
        return time24hr;

    }
public String TimeConverter24_12(String H24) {
    String timeString = H24;
    DateTimeFormatter formatter24hr = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.ENGLISH);
    LocalTime time = LocalTime.parse(timeString, formatter24hr);
    String time12hr = time.format(DateTimeFormatter.ofPattern("hh:mm a"));
    return time12hr;
}
    
    
}
