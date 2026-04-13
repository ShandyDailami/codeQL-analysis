import java.io.*;
import java.net.*;

public class java_25206_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create stream handler
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                // Receive message from client
                String message = input.readUTF();
                System.out.println("Received message: " + message);

                // Send response to client
                output.writeUTF("Message received");

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}