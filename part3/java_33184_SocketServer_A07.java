import java.io.*;
import java.net.*;

public class java_33184_SocketServer_A07 {

    private static final String CLIENT_IDENTIFIER = "CLIENT";
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started with port number: " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client " + CLIENT_IDENTIFIER + " connected.");

                // Perform authentication
                if (authenticateClient(client)) {
                    handleClient(client);
                } else {
                    System.out.println("Authentication failed for client " + CLIENT_IDENTIFIER);
                    client.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticateClient(Socket client) {
        // Simulate authentication by reading a specific message from the client
        try {
            DataInputStream in = new DataInputStream(client.getInputStream());
            String message = in.readUTF();

            // For simplicity, let's assume a valid message is "A07_AuthFailure"
            return message.equals("A07_AuthFailure");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void handleClient(Socket client) {
        try {
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            out.writeUTF("Hello, Client!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}