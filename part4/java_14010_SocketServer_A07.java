import java.io.*;
import java.net.*;

public class java_14010_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        // Create socket
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Waiting for client...");

        // Accept incoming client
        Socket socket = serverSocket.accept();
        System.out.println("Client accepted!");

        // Get input and output streams
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // Read request from client
        String request = in.readUTF();
        System.out.println("Received request: " + request);

        // Authentication
        if ("auth".equals(request)) {
            // Assume that the authentication is successful
            out.writeUTF("AuthSuccess");
        } else {
            out.writeUTF("AuthFailure");
        }

        // Close connection
        out.close();
        in.close();
        socket.close();
        serverSocket.close();
    }
}