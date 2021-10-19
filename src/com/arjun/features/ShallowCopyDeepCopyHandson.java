package com.arjun.features;

import java.util.Arrays;

public class ShallowCopyDeepCopyHandson {
    private int[] shallowCopyInt;
    private int[] deepCopyIntArray;
    private boolean isDeepCopy;

    // makes a shallow copy of values
    public ShallowCopyDeepCopyHandson(int[] values, boolean isDeepCopy) {
        this.isDeepCopy = isDeepCopy;
        if (isDeepCopy) {
            deepCopyIntArray = new int[values.length];
            for (int i = 0; i < deepCopyIntArray.length; i++) {
                deepCopyIntArray[i] = values[i];
            }
        } else {
            shallowCopyInt = values;
        }

    }


    public void showData() {
        if(!isDeepCopy)
            System.out.println("shallowCopyInt: " + Arrays.toString(shallowCopyInt));
        else
            System.out.println("deepCopyIntArray: " + Arrays.toString(deepCopyIntArray));
    }

    public static void main(String[] args) {


        ShallowCopyDeepCopyHandson shallowCopyHandson = new ShallowCopyDeepCopyHandson(new int[]{5, 4, 3, 2, 1, 9, 8, 7, 6}, false);
        shallowCopyHandson.showData();

        int[] vals = {3, 7, 9};
        ShallowCopyDeepCopyHandson e = new ShallowCopyDeepCopyHandson(vals, false);
        e.showData(); // prints out [3, 7, 9]
        vals[0] = 13;
        e.showData(); // prints out [13, 7, 9]

        // Very confusing, because we didn't
        // intentionally change anything about
        // the object e refers to.


        ShallowCopyDeepCopyHandson deepCopyHandson = new ShallowCopyDeepCopyHandson(new int[]{5, 4, 3, 2, 1, 9, 8, 7, 6}, true);
        deepCopyHandson.showData();


    }
}
