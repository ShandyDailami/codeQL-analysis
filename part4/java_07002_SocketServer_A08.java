import java.io.*;
import java.net.*;

public class java_07002_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Perform the integrity check
            try {
                performIntegrityCheck(socket);
            } catch (Exception e) {
                System.out.println("Integrity check failed");
                socket.close();
                continue;
            }

            // Handle the request
            handleRequest(socket);

            socket.close();
        }
    }

    private static void performIntegrityCheck(Socket socket) throws IOException {
        // Simulate an integrity check by sending back a static response
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println("Integrity check successful");
    }

    private static void handleRequest(Socket socket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String request = reader.readLine();
        System.out.println("Received request: " + request);

        // Process the request (e.g., perform some operations)
        // Simulate a response
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println("Received request processed");
    }
}