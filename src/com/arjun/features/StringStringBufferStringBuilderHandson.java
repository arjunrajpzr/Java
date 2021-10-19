package com.arjun.features;

public class StringStringBufferStringBuilderHandson {

    private String name;
    private String sirName = "Mr";

    // A mutable sequence of characters.
    // This class is designed for use as a drop-in replacement for StringBuffer in places where the string buffer was being used by a single thread (as is generally the case).
    // Faster than StringBuffer.
    // If sb refers to an instance of a StringBuilder, then sb.append(x) has the same effect as sb.insert(sb.length(), x).
    // Both effectively converts a given datum to a string and then appends or inserts the characters of that string to the string buffer.
    private StringBuilder permanentAddress;

    //A thread-safe, mutable sequence of characters. A string buffer is like a String, but can be modified.
    //
    private StringBuffer temporaryAddress;

    private void setName(String name) {
        this.name = new String(name);
    }

    private void setPermanentAddress(StringBuilder permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    private void setTemporaryAddress(StringBuffer temporaryAddress) {
        this.temporaryAddress = temporaryAddress;
    }

    private void setSirName(String sirName) {
        this.sirName = sirName;
    }

    public void print() {
        System.out.println(String.format("StringStringBufferStringBuilderHandson{\nname='%s',\nsirName='%s',\npermanentAddress=%s, \ntemporaryAddress=%s}", name, sirName, permanentAddress, temporaryAddress));
    }

    public static void main(String[] args) {
        StringStringBufferStringBuilderHandson demo = new StringStringBufferStringBuilderHandson();

        StringBuilder permanentAddress = new StringBuilder().append("address1, ").insert(8, "address2, ").append("address3");

        demo.setName("Arjun");
        demo.setPermanentAddress(permanentAddress);
        demo.setTemporaryAddress(new StringBuffer(permanentAddress));

        demo.print();

    }
}
