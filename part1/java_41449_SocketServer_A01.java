import java.io.*;
import java.net.*;

public class java_41449_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 6000;
        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        try {
            // Step 1: Create a ServerSocket and wait for client
            serverSocket = new ServerSocket(port);
            System.out.println("Server listening on port " + port);

            // Step 2: Accept a client socket
            clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Step 3: Send a message to the client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Hello, Client, How are you?");

            // Step 4: Close the connection
            // serverSocket.close();
            // clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Always close the socket and prevent potential memory leaks
            try {
                if (clientSocket != null) clientSocket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}