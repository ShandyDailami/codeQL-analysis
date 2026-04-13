import java.net.*;
import java.io.*;

public class java_09216_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        int port = 5000;
        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Server is running on port " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();

            System.out.println("A new client is connected: " + clientSocket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String request = in.readUTF();
            System.out.println("Received request: " + request);

            // You can add code here to securely perform operations related to injection
            // For instance, sanitizing input to prevent SQL injection
            request = sanitizeInput(request);

            out.writeUTF("Received your message: " + request);
            out.flush();

            clientSocket.close();
        }
    }

    private static String sanitizeInput(String input) {
        // This is a simple example of sanitization, you should do actual sanitization in your code
        return input.replaceAll("[^a-zA-Z0-9 ]", "");
    }
}