package com.arjun.business;

import com.arjun.features.InnerClassInterface;
import com.arjun.features.OuterClassInterface;

/**
 * As with instance methods and variables,
 * an inner class is associated with an instance of its enclosing class and
 * has direct access to that object's methods and fields.
 * Also, because an inner class is associated with an instance,
 * it cannot define any static members itself.
 * <p>
 * An instance of InnerClass can exist only within an instance of OuterClass and has direct access to the methods and fields of its enclosing instance.
 */
public class OuterClass implements OuterClassInterface {
    private int x = 10;

    public int getOuterClassVariable() {
        return x;
    }

    public int getVariable() {
        return x;
    }

    public class InnerClass implements InnerClassInterface {
        int y = 5;

        public int getInnerClassVariable() {
            return y;
        }

        public int getVariable() {
            return y;
        }

        public int getOuterClassVariable() {
            return x;
        }

    }


}