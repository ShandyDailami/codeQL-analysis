import java.io.*;
import java.net.*;

public class java_17530_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server is waiting for client connection...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        // Create input and output streams
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        // Get the username from client
        String clientName = dis.readUTF();
        System.out.println("Client's name: " + clientName);

        // Check if client is authorized
        if (isAuthorized(clientName)) {
            System.out.println("Client is authorized!");
            // Send a message to client
            dos.writeUTF("Hello, " + clientName + "!");
        } else {
            System.out.println("Client is not authorized!");
            // Send an auth failure response
            dos.writeUTF("Auth Failure");
        }

        // Close the connection
        socket.close();
        serverSocket.close();
    }

    // Simulated method to check if client is authorized
    private static boolean isAuthorized(String clientName) {
        // Simulated check for A07_AuthFailure
        return clientName.equals("admin");
    }
}