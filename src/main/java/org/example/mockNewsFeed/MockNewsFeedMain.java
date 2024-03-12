package org.example.mockNewsFeed;

import org.example.entity.NewsItem;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class MockNewsFeedMain {
    public static void main(String[] args) {
        String analyzerHost = "localhost";
        int analyzerPort = 11111;
        int frequency = Integer.parseInt(System.getProperty("news.frequency", "5000"));

        try(Socket socket = new Socket(analyzerHost,analyzerPort);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())

        ) {


            while (true) {
                String headline = MockNewsFeed.generateHeadline();
                int priority = MockNewsFeed.generatePriority();
                NewsItem newsItem = new NewsItem(headline, priority);
                outputStream.writeObject(newsItem);
                System.out.println("Sent: " + newsItem);
                Thread.sleep(frequency * 1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    }
