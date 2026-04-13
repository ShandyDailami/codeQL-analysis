import java.io.*;
import java.net.*;

public class java_26076_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 1234;
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            while (true) {
                try (Socket socket = server.accept()) {
                    System.out.println("Client connected");
                    handleRequest(socket);
                }
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection: " + e.getMessage());
        }
    }

    private static void handleRequest(Socket socket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String message = in.readLine();
            System.out.println("Received: " + message);
            // Handle the request here

            // Example of integrity failure (client sends a message and then closes connection)
            if (message.equals("A08_IntegrityFailure")) {
                System.out.println("Integrity failure detected, closing connection");
                socket.close();
            }
        } catch (IOException e) {
            System.out.println("Error handling client request: " + e.getMessage());
        }
    }
}