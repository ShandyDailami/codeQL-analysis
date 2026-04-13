import java.io.*;
import java.net.*;

public class java_34435_SocketServer_A01 {
    public static void main(String[] args) {
        // Create a socket server
        try (ServerSocket server = new ServerSocket(5000)) {
            System.out.println("Server is listening...");

            // Listen for clients
            while (true) {
                try (Socket socket = server.accept()) {
                    System.out.println("Client connected!");

                    // Create input and output streams
                    try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                         PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                        // Read from client
                        String message = in.readLine();
                        System.out.println("Received: " + message);

                        // Reply with hello
                        out.println("Hello, client!");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}