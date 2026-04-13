import java.io.*;
import java.net.*;

public class java_03730_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            // Set up server socket
            serverSocket = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            while (true) {
                // Wait for client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Send a greeting message to the client
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("Hello, Client!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close server socket
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}