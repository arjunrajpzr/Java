package com.arjun.features;

import com.arjun.business.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionHandson {

    public void runReflectionSample() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Test test=new Test();

        Class cls=test.getClass();

        System.out.println("Class name: "+cls.getName());
        System.out.println("Package name: "+cls.getPackageName());


        Constructor[] constructors=cls.getConstructors();

        System.out.println("=============Constructor name(s): ==================");
        for(Constructor constructor:constructors){
            System.out.println(constructor.getName());
        }


        Method[] methods=cls.getMethods();

        System.out.println("===============Method name(s): =================");
        for(Method method:methods){
            System.out.println(method.getName());
        }


        Method methodCall=cls.getDeclaredMethod("printIncomingValue",int.class);

        methodCall.invoke(test, 20);

        Field field=cls.getDeclaredField("string");

        field.setAccessible(true);

        field.set(test, "JAVA");

        Method method=cls.getDeclaredMethod("printValue");

        method.invoke(test);

    }
}
