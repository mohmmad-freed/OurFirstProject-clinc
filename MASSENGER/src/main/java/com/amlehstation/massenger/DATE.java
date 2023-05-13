/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amlehstation.massenger;
import java.time.LocalDate;
import java.time.Month;
/**
 *
 * @author msamalq
 */
// setDay(int) , getDate() <-- methods
public class DATE {
   private int time;
    private LocalDate date; 
    private int meetingDuration;

    public void DATE( int year,int month,int day,int hours, int minutes, int meetingDuration) {
        this.time = hours * 100 + minutes;
        this.date = LocalDate.of(year, month, day);
        this.meetingDuration = meetingDuration;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getMeetingTime() {
        return meetingDuration;
    }

    public void setMeetingDuration(int meetingTime) {
        this.meetingDuration = meetingTime;
    }
    
    public void setDay(int day) {
        LocalDate newDate = date.withDayOfMonth(day);
        this.date = newDate;
    }
    
    public void setDate(int year, int month, int day) {
        LocalDate newDate = LocalDate.of(year, month, day);
        this.date = newDate;
    }
    
    public void setTime(int hours, int minutes) {
        this.time = hours * 100 + minutes;
    }
    
    public int getHours() {
        return time / 100;
    }
    
    public int getMinutes() {
        return time % 100;
    }
    
    public String getTimeString() {
        return String.format("%02d:%02d", getHours(), getMinutes());
    }
}

    

    

