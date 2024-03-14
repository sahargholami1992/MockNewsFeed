package org.example.mockNewsFeed;

import org.example.entity.NewsItem;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.TimerTask;

public class SendTask extends TimerTask {

    private static final String serverAddress = "localhost";
    private static final int serverPort = 11111;

    @Override
    public void run() {
        try (
                Socket socket = new Socket(serverAddress, serverPort);
                OutputStream outputStream = socket.getOutputStream()
        ) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            String headline = MockNewsFeed.generateHeadline();
            int priority = MockNewsFeed.generatePriority();
            NewsItem newsItem = new NewsItem(headline, priority);
            objectOutputStream.writeObject(newsItem);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


}
