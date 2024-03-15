package org.example.mockNewsFeed;

import java.util.Scanner;
import java.util.Timer;


public class MockNewsFeedMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter newsFrequency in second: ");
        long frequency = scanner.nextInt();
        Timer timer = new Timer();
        timer.schedule(new SendTask(), 0, frequency * 1000);
    }
}
