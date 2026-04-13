import java.io.*;
import java.net.*;

public class java_41603_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // Server port
        System.out.println("Server started. Waiting for client connections...");

        while (true) {
            Socket socket = serverSocket.accept(); // Wait for client connection
            System.out.println("Client connected!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receive the client's message
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Check for injection attacks (replace 'inject' with your code)
            if (message.contains("inject")) {
                System.out.println("Injection detected, aborting transmission!");
                out.writeUTF("Injection aborted.");
            } else {
                // Send back a response
                String response = "Hello, client, your message is: " + message;
                out.writeUTF(response);
            }

            out.close();
            socket.close();
        }
    }
}