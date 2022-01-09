package com.arjun.design.patterns;

/**
 * A real world example can be a cheque or credit card is a proxy for what is in our bank account.
 * It can be used in place of cash, and provides a means of accessing that cash when required.
 * And that’s exactly what the Proxy pattern does – “Controls and manage access to the object they are protecting“.
 * <p>
 * Remote proxy:
 * They are responsible for representing the object located remotely.
 * Talking to the real object might involve marshalling and unmarshalling of data and talking to the remote object.
 * All that logic is encapsulated in these proxies and the client application need not worry about them.
 * <p>
 * Virtual proxy:
 * <p>
 * These proxies will provide some default and instant results if the real object is supposed to take some time to produce results.
 * These proxies initiate the operation on real objects and provide a default result to the application. Once the real object is done,
 * these proxies push the actual data to the client where it has provided dummy data earlier.
 * <p>
 * Protection proxy:
 * <p>
 * If an application does not have access to some resource then such proxies will talk to the objects in applications that have access to that resource
 * and then get the result back.
 * <p>
 * Smart Proxy:
 * <p>
 * A smart proxy provides additional layer of security by interposing specific actions when the object is accessed.
 * An example can be to check if the real object is locked before it is accessed to ensure that no other object can change it.
 */

/**
 * Here for demo we are using Protection Proxy
 */

public class ProxyPatternMain {
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();
        try {
            internet.connectTo("geeksforgeeks.com");
            internet.connectTo("abc.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
