import java.io.*;
import java.net.*;

public class java_11953_SocketServer_A08 {

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(8080); // Create a server socket
            System.out.println("Server started on port 8080");

            while (true) {

                Socket socket = server.accept(); // Accept client connection

                // Create streams
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // Read the request
                String request = dis.readUTF();
                System.out.println("Received: " + request);

                // Send a response
                String response = "Hello, Client!";
                dos.writeUTF(response);
                dos.flush();

                socket.close(); // Close the connection

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}