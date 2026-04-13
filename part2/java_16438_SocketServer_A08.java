import java.io.*;
import java.net.*;

public class java_16438_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // Server socket
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Waiting for client connection...");

            // Accept incoming connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected to client");

            // Create input and output streams
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Send a welcome message to the client
            out.println("Welcome to the server!");

            // Listen for incoming messages
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println("Hello, client, your message was received!");
            }

            // Close resources
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}