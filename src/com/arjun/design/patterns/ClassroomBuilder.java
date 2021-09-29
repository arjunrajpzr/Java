package com.arjun.design.patterns;

public class ClassroomBuilder {
    private int numberOfStudents;
    private int numberOfBenches;
    private int numberOfDesks;
    private int numberOfFans;
    private int numberOfBlackBoards;

    public ClassroomBuilder(Builder builder) {
        this.numberOfStudents = builder.numberOfStudents;
        this.numberOfBenches = builder.numberOfBenches;
        this.numberOfDesks = builder.numberOfDesks;
        this.numberOfFans = builder.numberOfFans;
        this.numberOfBlackBoards = builder.numberOfBlackBoards;
    }

    public static class Builder {

        private int numberOfStudents;
        private int numberOfBenches;
        private int numberOfDesks;
        private int numberOfFans;
        private int numberOfBlackBoards;

        public Builder newInstance() {
            return new Builder();
        }

        private Builder(){

        }

        public Builder setNumberOfStudents(int numberOfStudents) {
            this.numberOfStudents = numberOfStudents;
            return this;
        }

        public Builder setNumberOfBenches(int numberOfBenches) {
            this.numberOfBenches = numberOfBenches;
            return this;
        }

        public Builder setNumberOfDesks(int numberOfDesks) {
            this.numberOfDesks = numberOfDesks;
            return this;
        }

        public Builder setNumberOfFans(int numberOfFans) {
            this.numberOfFans = numberOfFans;
            return this;
        }

        public Builder setNumberOfBlackBoards(int numberOfBlackBoards) {
            this.numberOfBlackBoards = numberOfBlackBoards;
            return this;
        }

        public ClassroomBuilder build() {
            return new ClassroomBuilder(this);
        }
    }
}
