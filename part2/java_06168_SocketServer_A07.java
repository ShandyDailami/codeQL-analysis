import java.io.*;
import java.net.*;

public class java_06168_SocketServer_A07 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create a server socket and listen on port 8000
            serverSocket = new ServerSocket(8000);
            System.out.println("Server is listening on port 8000");

            // Accept a client socket
            socket = serverSocket.accept();
            System.out.println("Client connected");

            // Send a message to the client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello, Client!");

            // Close the connection
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}