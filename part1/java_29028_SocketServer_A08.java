import java.io.*;
import java.net.*;

public class java_29028_SocketServer_A08 {
    private static final String SERVER_STATIC_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("Accepted connection from " + clientSocket.getRemoteSocketAddress());

                    DataInputStream input = new DataInputStream(clientSocket.getInputStream());
                    DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

                    // Read the request
                    String request = input.readUTF();
                    System.out.println("Received: " + request);

                    // Process the request (e.g., check for integrity failure)
                    if (processRequest(request)) {
                        output.writeUTF("Processed successfully");
                    } else {
                        output.writeUTF("Integrity failure during processing");
                    }

                    output.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean processRequest(String request) {
        // This is a placeholder for a real-world security-sensitive operation
        // You should replace this with your actual operation
        // For now, we will just simulate a failure
        if (request.contains("fail")) {
            return false;
        }
        return true;
    }
}