import java.io.*;
import java.net.*;

public class java_01378_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected with IP: " + clientSocket.getInetAddress().getHostAddress());

                DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());

                String message = inputStream.readUTF();
                System.out.println("Received: " + message);

                // Simulating integrity failure
                if (message.equals("fail")) {
                    throw new RuntimeException("Integrity failure");
                }

                outputStream.writeUTF("Successfully received");
                System.out.println("Sent: Successfully received");
            }
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}