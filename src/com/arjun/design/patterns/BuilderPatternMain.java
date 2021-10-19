package com.arjun.design.patterns;

public class BuilderPatternMain {
    public static void main(String[] args) {
        ClassroomBuilder classroom = ClassroomBuilder.Builder.newInstance().setNumberOfBenches(5).setNumberOfBlackBoards(1).setNumberOfDesks(5).setNumberOfStudents(25).setNumberOfFans(2).build();

        System.out.println(classroom.toString());
    }
}
