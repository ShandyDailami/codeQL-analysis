import java.io.*;
import java.net.*;

public class java_37682_SocketServer_A03 {
    private static final int PORT = 3333;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started at port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected at " + socket.getRemoteSocketAddress());

            // Create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Read request from client
            String request = input.readUTF();
            System.out.println("Received request: " + request);

            // Process request
            String response = processRequest(request);

            // Send response back to client
            output.writeUTF(response);
            output.flush();

            socket.close();
        }
    }

    private static String processRequest(String request) {
        // Process request here for security-sensitive operations related to A03_Injection
        // For example, use a placeholder or a library for secure operations
        return "Processed request: " + request;
    }
}