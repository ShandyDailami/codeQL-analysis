import java.io.*;
import java.net.*;

public class java_28829_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started. Listening for connections on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received message: " + message);

            String response = processRequest(message);
            output.writeUTF(response);
            output.flush();

            socket.close();
        }
    }

    private static String processRequest(String request) {
        // Here you can implement security-sensitive operations related to A03_Injection
        // This is a simple example, the real implementation may involve more complex operations
        return "Server response: " + request;
    }
}