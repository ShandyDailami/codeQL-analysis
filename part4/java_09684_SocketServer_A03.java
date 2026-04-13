import java.io.*;
import java.net.*;

public class java_09684_SocketServer_A03 {
    private static final String QUIT = "quit";
    private static boolean stopThreads = false;

    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Secure Socket Server started at port " + port);

            while (!stopThreads) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("Client connected");

                    DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                    DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                    String message;
                    while (!(message = in.readUTF()).equals(QUIT)) {
                        System.out.println("Received: " + message);
                        // Assume that the message is safe from SQL Injection and XSS attacks
                        // Use a PreparedStatement or similar to protect against these attacks
                        out.writeUTF("Thank you for message: " + message);
                        out.flush();
                    }
                    System.out.println("Client disconnected");
                } catch (IOException ex) {
                    System.out.println("Error communicating with client: " + ex.getMessage());
                    stopThreads = true;
                }
            }

            serverSocket.close();
        } catch (IOException ex) {
            System.out.println("Server failed: " + ex.getMessage());
        }

        System.out.println("Secure Socket Server stopped");
    }
}