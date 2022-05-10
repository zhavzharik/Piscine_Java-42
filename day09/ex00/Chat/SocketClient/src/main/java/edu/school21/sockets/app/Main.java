package edu.school21.sockets.app;

import edu.school21.sockets.client.Client;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

       try {
            Client client = new Client(8081);
            client.run();
            client.close();
        } catch (IOException e) {
            System.err.println(e);
//            e.printStackTrace();
        }
    }
}
