/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amlehstation.massenger;

/**
 *
 * @author msamalq
 */
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DSCHEDULE {
    
private Map<String, List<LocalTime>> DSCHEDULE = new HashMap<>();
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm");
    private static final int APPOINTMENT_DURATION_MINUTES = 15;

    public DSCHEDULE(String[] workingHours) {
        String currentDay = null;
        for (String hours : workingHours) {
            if (currentDay == null) {
                currentDay = hours;
            } else {
                String[] startAndEndTimes = hours.split("-");
                LocalTime startTime = LocalTime.parse(startAndEndTimes[0], TIME_FORMAT);
                LocalTime endTime = LocalTime.parse(startAndEndTimes[1], TIME_FORMAT);

                List<LocalTime> appointmentTimes = new ArrayList<>();
                while (startTime.plusMinutes(APPOINTMENT_DURATION_MINUTES).isBefore(endTime)) {
                    appointmentTimes.add(startTime);
                    startTime = startTime.plusMinutes(APPOINTMENT_DURATION_MINUTES);
                }
               DSCHEDULE.put(currentDay, appointmentTimes);
                currentDay = null;
            }
        }
    }

    public List<String[]> getAppointments() {
        List<String[]> appointments = new ArrayList<>();
        for (Map.Entry<String, List<LocalTime>> entry : DSCHEDULE.entrySet()) {
            String day = entry.getKey();
            List<LocalTime> appointmentTimes = entry.getValue();
            for (LocalTime time : appointmentTimes) {
                String[] appointment = {day, time.format(TIME_FORMAT)};
                appointments.add(appointment);
            }
        }
        return appointments;
    }
}
