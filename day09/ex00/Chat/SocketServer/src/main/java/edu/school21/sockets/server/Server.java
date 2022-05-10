package edu.school21.sockets.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket server;
    private Socket clientSocket;
    private int port;
    private BufferedReader in;
    private BufferedWriter out;

    public Server(int port) throws IOException{
        this.port = port;
    }

    public ServerSocket getServer() {
        return server;
    }

    public void setServer(ServerSocket server) {
        this.server = server;
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
        server = new ServerSocket(port);
        clientSocket = server.accept();

        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        out.write("Hello from Server!\n");
        out.flush();

        String word = in.readLine(); // signUp
//        System.out.println(word);

        out.write("Enter username:\n");
        out.flush();

        word = in.readLine(); // Marsel

        out.write("Enter password:\n");
        out.flush();

        word = in.readLine(); // qwerty007

        out.write("Successful!\n");
        out.flush();
    }

    public void close() throws IOException {
        clientSocket.close();
        in.close();
        out.close();
        server.close();
    }

}
