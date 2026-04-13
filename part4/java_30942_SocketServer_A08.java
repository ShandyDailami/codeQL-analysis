import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30942_SocketServer_A08 {
    private static final int PORT = 6789;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                try (Socket clientSocket = server.accept()) {
                    System.out.println("New client connected");

                    try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                         PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                        String request;
                        while ((request = in.readLine()) != null) {
                            System.out.println("Received: " + request);

                            // Process the request and send a response back
                            out.println("Server response: " + request);

                            // Here you can add your own security-sensitive operations
                            // For instance, you can add a check for the integrity of the request
                            // If the integrity check fails, you can send a response back to the client
                        }
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Error accepting client connection: " + ex);
        }
    }
}