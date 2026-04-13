import java.io.*;
import java.net.*;

public class java_36124_SocketServer_A03 {
    private static final int PORT = 8080;
    private static boolean running = true;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (running) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received message: " + message);

            String response = processMessage(message);
            out.writeUTF(response);
            System.out.println("Sent response: " + response);

            clientSocket.close();
        }

        serverSocket.close();
    }

    private static String processMessage(String message) {
        // Simple message processing, might include SQL injection
        // This is only for demonstration and should not be used in actual production code
        return "Processed: " + message;
    }
}