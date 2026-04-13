import java.io.*;
import java.net.*;

public class java_24384_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080); // Port 8080 is free
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept(); // Waits for a client to connect
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage;
            while ((clientMessage = in.readUTF()) != null) { // Waits for a message from a client
                System.out.println("Received message: " + clientMessage);
                out.writeUTF("Message received by server");
            }

            socket.close();
        }
    }
}