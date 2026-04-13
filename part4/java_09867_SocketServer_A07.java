import java.io.*;
import java.net.*;

public class java_09867_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        // Send handshake response
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        outputStream.writeUTF("Welcome to the server! Please enter your username:");

        // Read and validate username
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        String username = inputStream.readUTF();
        if ("admin".equals(username)) {
            outputStream.writeUTF("Username accepted");
        } else {
            outputStream.writeUTF("Username or password incorrect");
            socket.close();
            return;
        }

        // Start receiving messages
        while (true) {
            String message = inputStream.readUTF();
            System.out.println("Received: " + message);
            outputStream.writeUTF("Message received");
        }
    }
}