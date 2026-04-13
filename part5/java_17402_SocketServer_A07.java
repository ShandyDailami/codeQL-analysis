import java.io.*;
import java.net.*;
import java.util.*;

public class java_17402_SocketServer_A07 {
    private static int PORT = 8080;
    private static int RECEIVED_NUMBER = 0;
    private static boolean authenticated = false;

    public static void main(String[] args) throws IOException {
        // Create server socket
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is running...");

        // Accept incoming client
        Socket socket = server.accept();
        System.out.println("Client accepted!");

        // Create input and output streams
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Handle authentication
        while (!authenticated) {
            // Receive a message from client
            String message = in.readLine();
            System.out.println("Received: " + message);

            // Convert message to integer
            int messageNumber = Integer.parseInt(message);

            // Verify received number
            if (messageNumber == RECEIVED_NUMBER) {
                authenticated = true;
                System.out.println("Authentication successful!");
            } else {
                System.out.println("Authentication failed!");
                break;
            }
        }

        // Close resources
        in.close();
        out.close();
        socket.close();
        server.close();
    }
}