package com.arjun.java8features;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeApiHandson {

    private LocalDate localDate=LocalDate.now();
    private LocalTime localtime=LocalTime.now();
    private LocalDateTime localDateTime=LocalDateTime.now();
    LocalDateTime lclDtTme = LocalDateTime.of(2018, 1, 1, 10, 15, 50, 500);
    private DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private DateTimeFormatter deTimeFormatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss.SSS", Locale.GERMANY);
    public void useDateTimeApi(){

        System.out.println("LocalDate: "+localDate);


        System.out.println("LocalTime: "+localtime);


        System.out.println("LocalDateTime: "+localDateTime);


        System.out.println("DateTimeFormatter: "+localDateTime.format(format));


        System.out.println("Year: "+localDateTime.getYear());

        DateTimeFormatter parseFormat=DateTimeFormatter.ofPattern("HH:mm");
        System.out.println("String to Date: "+LocalTime.parse("12:10", parseFormat));

        System.out.println("Locale: "+lclDtTme.format(deTimeFormatter));
    }
}
