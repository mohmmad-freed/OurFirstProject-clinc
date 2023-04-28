/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amlehstation.massenger;
import java.time.LocalDate;
/**
 *
 * @author msamalq
 */
// setDay(int) , getDate() <-- methods
public class DATE {
   private int time;
    private LocalDate date; // ex: LocalDate date = LocalDate.of(2023, 5, 5);
    private int meetingTime;

    public void Date(int time, LocalDate date, int meetingTime) {
        this.time = time;
        this.date = date;
        this.meetingTime = meetingTime;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(int meetingTime) {
        this.meetingTime = meetingTime;
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

    

    

