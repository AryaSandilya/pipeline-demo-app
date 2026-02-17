package com.example.app;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello from Jenkins Pipeline!");
        System.out.println("Build Date: " + java.time.LocalDateTime.now());
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("Hi there!");
        System.out.println("Version 2.0 - Auto deployed by Jenkins!"); 
    }
}

