import java.io.*;
import java.net.*;
import java.util.*;

public class java_20764_SocketServer_A07 {
    private int port;
    private ServerSocket serverSocket;

    public java_20764_SocketServer_A07(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Received: " + clientMessage);

            String serverMessage = "Server: " + clientMessage;
            out.writeUTF(serverMessage);
            System.out.println("Sent: " + serverMessage);

            clientSocket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(8080);
        server.start();
    }
}