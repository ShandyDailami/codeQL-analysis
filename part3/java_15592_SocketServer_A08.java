import java.io.*;
import java.net.*;

public class java_15592_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(12345); // Bind to port 12345
            System.out.println("Waiting for client...");

            Socket socket = server.accept(); // Wait for client connection

            System.out.println("Connected to client");

            // Send a welcome message
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Connection established!");

            // Receive request from client and print out message
            DataInputStream in = new DataInputStream(socket.getInputStream());
            System.out.println("Received: " + in.readUTF());

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}