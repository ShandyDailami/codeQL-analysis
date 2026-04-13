import java.io.*;
import java.net.*;

public class java_21921_SocketServer_A03 {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            // Create a ServerSocket and bind it to a port
            server = new ServerSocket(6000);
            System.out.println("Server is listening on port 6000");

            // Wait for a client to connect
            socket = server.accept();
            System.out.println("Client connected");

            // Send a welcome message to the client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Welcome to the server!");

            // Close the resources
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
       
        }
    }
}