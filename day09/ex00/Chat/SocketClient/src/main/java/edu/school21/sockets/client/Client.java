package edu.school21.sockets.client;

import java.io.*;
import java.net.Socket;

public class Client {

    private Socket clientSocket;
    private int port;
    private BufferedReader reader;
    private BufferedReader in;
    private BufferedWriter out;

    public Client(int port) throws IOException {
        this.port = port;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public BufferedReader getReader() {
        return reader;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public BufferedReader getIn() {
        return in;
    }

    public void setIn(BufferedReader in) {
        this.in = in;
    }

    public BufferedWriter getOut() {
        return out;
    }

    public void setOut(BufferedWriter out) {
        this.out = out;
    }

    public void run() throws IOException {
        clientSocket = new Socket("localhost", port);

        reader = new BufferedReader(new InputStreamReader(System.in));
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        String serverWord = in.readLine(); // Hello from Server!
        System.out.println(serverWord);

        String word = reader.readLine(); // signUp
        out.write(word + "\n");
        out.flush();

        serverWord = in.readLine(); // Enter username:
        System.out.println(serverWord);

        word = reader.readLine(); // Marsel
        out.write(word + "\n");
        out.flush();

        serverWord = in.readLine(); // Enter password:
        System.out.println(serverWord);

        word = reader.readLine(); // qwerty007
        out.write(word + "\n");
        out.flush();

        serverWord = in.readLine(); // Successful!
        System.out.println(serverWord);

    }

    public void close() throws IOException {
        clientSocket.close();
        in.close();
        out.close();
    }
}
