import java.io.*;
import java.net.*;

public class java_00223_SocketServer_A08 {

    // Server socket
    private static ServerSocket server;

    public static void main(String[] args) {
        try {
            // Create server socket
            server = new ServerSocket(8080);
            System.out.println("Server started...");
            while (true) {
                // Wait for client connection
                Socket client = server.accept();
                System.out.println("Client connected: " + client.getInetAddress().getHostAddress());

                // Create input and output stream
                DataInputStream dis = new DataInputStream(client.getInputStream());
                DataOutputStream dos = new DataOutputStream(client.getOutputStream());

                // Read from client
                String message = dis.readUTF();
                System.out.println("Received: " + message);

                // Write response
                dos.writeUTF("Message received successfully: " + message);
                dos.flush();

                // Close connection
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}