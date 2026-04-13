import java.net.*;
import java.io.*;
import java.util.*;

class java_01113_SocketServer_A07 {
    private static final String ALLOWED_IP = "127.0.0.1"; // Only accept connections from this IP
    private static final int PORT = 12345; // The port on which the server listens

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                System.out.println("Waiting for client connection...");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Check if the client's IP is in the allowed list
                InetAddress clientAddress = socket.getInetAddress();
                if (ALLOWED_IP.equals(clientAddress.getHostAddress())) {
                    System.out.println("Client is allowed to connect");
                    handleClient(socket);
                } else {
                    System.out.println("Client is not allowed to connect");
                    closeConnection(socket);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        try {
            // Here you can add your server's logic
            // For example, you could send a message to the client
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);
            writer.println("Server is working");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void closeConnection(Socket socket) {
        try {
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}