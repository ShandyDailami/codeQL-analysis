import java.io.*;
import java.net.*;
import java.util.*;

public class java_33682_SocketServer_A01 {
    private int port;
    private boolean running;

    public java_33682_SocketServer_A01(int port) {
        this.port = port;
        this.running = true;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);

        while(running) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            String response = "Echo: " + message;
            out.writeUTF(response);
            System.out.println("Sent: " + response);

            clientSocket.close();
        }

        serverSocket.close();
    }

    public void stop() {
        this.running = false;
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(8001);
        server.start();
    }
}