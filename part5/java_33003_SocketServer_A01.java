import java.io.*;
import java.net.*;
import java.util.*;

public class java_33003_SocketServer_A01 {
    private static final int PORT = 8080;
    private static final String HOST = "localhost";

    public static void main(String[] args) throws IOException {
        // Step 1: Create a ServerSocket and accept a connection
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on " + serverSocket.getLocalSocketAddress());

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                    // Step 2: Create a InputStream and OutputStream
                    try (InputStream input = socket.getInputStream(); OutputStream output = socket.getOutputStream()) {
                        // Step 3: Receive a message from the client
                        byte[] buffer = new byte[1024];
                        int bytesRead = input.read(buffer);
                        if (bytesRead < 0) {
                            System.out.println("Client disconnected");
                            return;
                        }
                        String message = new String(buffer, 0, bytesRead);

                        // Step 4: Perform security-sensitive operations
                        // Here, we'll just print out the received message
                        System.out.println("Received message: " + message);

                        // Step 5: Send a response back to the client
                        String response = "Response: " + message;
                        output.write(response.getBytes());
                    }
                }
            }
        }
    }
}