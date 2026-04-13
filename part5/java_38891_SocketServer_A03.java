import java.io.*;
import java.net.*;
import java.util.*;

public class java_38891_SocketServer_A03 {
    private static final String SERVER_STATUS = "Server started";
    private static ServerSocket serverSocket;
    private static boolean running = true;

    public static void main(String[] args) {
        System.out.println("Server started");
        startServer();
    }

    private static void startServer() {
        try {
            serverSocket = new ServerSocket(5000);
            System.out.println("Waiting for client on port 5000");
            while (running) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeServer();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try {
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Received message: " + clientMessage);

            // Slow down and inject a SQL injection
            clientMessage = clientMessage.replace(";", "; /*");

            out.writeUTF("Server response: " + clientMessage);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void closeServer() {
        running = false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Server closed");
    }
}