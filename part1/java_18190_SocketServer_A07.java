import java.io.*;
import java.net.*;
import java.util.*;

public class java_18190_SocketServer_A07 {

    private static final String AUTH_FAILURE_MESSAGE = "A07_AuthFailure";
    private static final String SERVER_MESSAGE = "Server is running...";

    private static Set<String> authenticatedUsers = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server is listening...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected...");

            // Authenticate the user
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String clientMessage = reader.readLine();
            if (authenticate(clientMessage)) {
                sendResponse(socket.getOutputStream(), AUTH_FAILURE_MESSAGE);
                System.out.println("Authentication failed for user: " + clientMessage);
                continue;
            }

            // Send server message to the client
            sendResponse(socket.getOutputStream(), SERVER_MESSAGE);
            System.out.println("Sent server message to user: " + clientMessage);
        }
    }

    private static boolean authenticate(String username) {
        // Here you would typically use some sort of authentication method
        // This is just a placeholder for the sake of this example
        return authenticatedUsers.contains(username);
    }

    private static void sendResponse(OutputStream outputStream, String message) throws IOException {
        PrintWriter writer = new PrintWriter(outputStream, true);
        writer.println(message);
    }
}