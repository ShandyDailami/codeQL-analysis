import java.net.*;
import java.io.*;

public class java_22808_SocketServer_A08 {
    private static final String SERVER_NAME = "SocketServer";
    private static final int SERVER_PORT = 8080;
    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static DataInputStream input;
    private static DataOutputStream output;

    public static void main(String[] args) {
        try {
            // Create the server socket
            serverSocket = new ServerSocket(SERVER_PORT, 50, null);
            System.out.println("Server Started");

            while (true) {
                // Wait for a client to connect
                clientSocket = serverSocket.accept();
                System.out.println("Client Connected");

                // Get streams from the client socket
                input = new DataInputStream(clientSocket.getInputStream());
                output = new DataOutputStream(clientSocket.getOutputStream());

                // Handshake with the client
                String clientName = input.readUTF();
                System.out.println("Client Name: " + clientName);
                output.writeUTF("Hello, " + clientName);

                // Start data exchange
                while (true) {
                    String message = input.readUTF();
                    System.out.println("Received: " + message);
                    String response = "Server says: " + message;
                    output.writeUTF(response);
               
                    // End the session if client sends 'exit'
                    if (message.equals("exit")) {
                        output.close();
                        input.close();
                        clientSocket.close();
                        serverSocket.close();
                        System.out.println("End Session");
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}