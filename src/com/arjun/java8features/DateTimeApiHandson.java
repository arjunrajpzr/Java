package com.arjun.java8features;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeApiHandson {

    private LocalDate localDate = LocalDate.now();
    private LocalTime localtime = LocalTime.now();
    private LocalDateTime localDateTime = LocalDateTime.now();
    LocalDateTime lclDtTme = LocalDateTime.of(2018, 1, 1, 10, 15, 50, 500);
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private DateTimeFormatter deTimeFormatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss.SSS", Locale.GERMANY);

    public void useDateTimeApi() {

        System.out.println("LocalDate: " + localDate);


        System.out.println("LocalTime: " + localtime);


        System.out.println("LocalDateTime: " + localDateTime);

        LocalDate theDate = localDateTime.toLocalDate();
        Month month = localDateTime.getMonth();
        int day = localDateTime.getDayOfMonth();

        System.out.println("Date: " + theDate);
        System.out.println("Month: " + month);
        System.out.println("Day: " + day);
        System.out.println("Second: " + localDateTime.getSecond());

        System.out.println("DateTimeFormatter: " + localDateTime.format(format));


        System.out.println("Year: " + localDateTime.getYear());

        DateTimeFormatter parseFormat = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println("String to Date: " + LocalTime.parse("12:10", parseFormat));

        System.out.println("Locale: " + lclDtTme.format(deTimeFormatter));

        System.out.println("ofEpochDay: " + LocalDate.ofEpochDay(150));      // middle of 1970


        // A duration of 3 seconds and 5 nanoseconds
        Duration duration = Duration.ofSeconds(3, 5);
        System.out.println("Duration between 3 and 5 seconds: "+duration);

    }
}
