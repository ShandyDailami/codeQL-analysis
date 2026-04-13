import java.io.*;
import java.net.*;

public class java_29911_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received message: " + message);

            // Simple Injection Attack
            // Here, we are just echoing back the message received
            String response = message;

            output.writeUTF("Message received: " + response);
            output.flush();
            socket.close();
        }
    }
}