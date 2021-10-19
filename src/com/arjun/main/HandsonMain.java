package com.arjun.main;


import com.arjun.business.Test;
import com.arjun.business.Tuple;
import com.arjun.features.GenericsHandson;
import com.arjun.features.ReflectionHandson;
import com.arjun.java8features.DateTimeApiHandson;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class HandsonMain {


    public static void main(String args[]) {
        //GenericsHandson.hrDemo();
        DateTimeApiHandson handon=new DateTimeApiHandson();
        handon.useDateTimeApi();

    }
}