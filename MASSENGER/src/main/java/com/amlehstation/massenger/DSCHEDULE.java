/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amlehstation.massenger;

/**
 *
 * @author msamalq
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DSCHEDULE {
    private final String[] days;
    private final int[] startTimes;
    private final int[] endTimes;
    private final int[] appointmentCounts;

    public DSCHEDULE(String[] schedule) {
        int numDays = schedule.length / 2;
        days = new String[numDays];
        startTimes = new int[numDays];
        endTimes = new int[numDays];
        appointmentCounts = new int[numDays];

        // Parse the schedule array
        for (int i = 0; i < numDays; i++) {
            days[i] = schedule[i * 2];
            String[] times = schedule[i * 2 + 1].split(":");
            startTimes[i] = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1].substring(0, 2));
            endTimes[i] = Integer.parseInt(times[2]) * 60 + Integer.parseInt(times[3]);
            appointmentCounts[i] = (endTimes[i] - startTimes[i]) / 15;
        }
    }

    public String[][] getAppointments() {
        String[][] appointments = new String[days.length][];
        for (int i = 0; i < days.length; i++) {
            int numAppointments = appointmentCounts[i];
            String[] apps = new String[numAppointments];
            int startTime = startTimes[i];
            for (int j = 0; j < numAppointments; j++) {
                int hours = startTime / 60;
                int minutes = startTime % 60;
                String hourStr = (hours < 10) ? "0" + hours : "" + hours;
                String minuteStr = (minutes < 10) ? "0" + minutes : "" + minutes;
                apps[j] = hourStr + ":" + minuteStr;
                startTime += 15;
            }
            appointments[i] = new String[]{days[i], String.join(" ", apps)};
        }
        return appointments;
    }

    public static void main(String[] args) {
        String[] schedule = {"Saturday","10:00-13:00","Sunday","11:00-13:30"};
        DSCHEDULE ds = new DSCHEDULE(schedule);
        String[][] appointments = ds.getAppointments();
        for (String[] app : appointments) {
            System.out.println(app[0] + " " + app[1]);
        }
    }
}
