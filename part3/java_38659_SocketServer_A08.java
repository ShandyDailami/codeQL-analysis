import java.io.*;
import java.net.*;

public class java_38659_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket server = new ServerSocket(6000);

            // Listen for incoming connections
            System.out.println("Server is listening on port 6000");

            while (true) {
                Socket socket = server.accept();

                // Create a new thread to handle the client request
                new Thread(() -> handleClient(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        try {
            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read from the client
            String request = in.readLine();
            System.out.println("Received: " + request);

            // Simple integrity check
            if (request.equals("Hello, client")) {
                out.println("Hello, server");
            } else {
                out.println("Error: Invalid request");
            }

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}