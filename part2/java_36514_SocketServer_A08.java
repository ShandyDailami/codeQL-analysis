import java.io.*;
import java.net.*;

public class java_36514_SocketServer_A08 {
    private static final String ALLOWED_IP = "127.0.0.1"; // Only localhost is allowed

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started on port 12345");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            String clientIP = socket.getRemoteSocketAddress().toString();
            if (!isClientAllowed(clientIP)) {
                System.out.println("Client IP " + clientIP + " is not allowed to connect");
                socket.close();
                continue;
            }

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            out.writeUTF("Message received: " + message);
            socket.close();
        }
    }

    private static boolean isClientAllowed(String clientIP) {
        return clientIP.equals(ALLOWED_IP);
    }
}