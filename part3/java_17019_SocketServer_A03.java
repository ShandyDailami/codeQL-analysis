import java.io.*;
import java.net.*;

public class java_17019_SocketServer_A03 {
    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started at port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received message from client: " + message);

            // Perform security-sensitive operations such as injection attacks
            // For example, a check for SQL injection
            if (message.contains("'")) {
                System.out.println("SQL Injection detected, ignoring message");
                out.writeUTF("Ignoring SQL Injection");
            } else {
                out.writeUTF("Hello, client!");
            }

            socket.close();
        }
    }
}