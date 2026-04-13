import java.net.*;
import java.io.*;

public class java_21725_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server started at port 8080");

            while (true) {
                // Accept a new client connection
                Socket socket = server.accept();
                System.out.println("New client connected");

                // Create input and output streams
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // Read a message from the client
                String message = dis.readUTF();
                System.out.println("Received: " + message);

                // Send a response back to the client
                String response = "Hello, Client!";
                dos.writeUTF(response);
                System.out.println("Sent: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}