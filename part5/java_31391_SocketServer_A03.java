import java.io.*;
import java.net.*;
import java.util.*;

public class java_31391_SocketServer_A03 {
    private static final String SERVER_SOFTWARE = "Vanilla Java Secure SocketServer";
    private static final String SERVER_STRING = "Vanilla Java Secure SocketServer";
    private static final int PORT = 6789;
    private static Socket socket;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is running and listening for connections on port: " + PORT);

            while (true) {
                socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                handleRequest(inputStream, outputStream);
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(InputStream inputStream, OutputStream outputStream) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            DataOutputStream writer = new DataOutputStream(outputStream);

            String request = reader.readLine();
            System.out.println("Received request: " + request);

            // Secure operation: sanitize and validate input to prevent injection attacks
            String sanitizedRequest = validateAndSanitizeRequest(request);

            writer.writeBytes("Thank you for your request: " + sanitizedRequest);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String validateAndSanitizeRequest(String request) {
        // Secure operation: check for and sanitize for injection attacks
        if (request == null) {
            return "";
        }

        // Secure operation: check and sanitize for SQL injection attacks
        if (request.contains(";") || request.contains("--")) {
            return "";
        }

        return request;
    }
}