import java.io.*;
import java.net.*;

public class java_27488_SocketServer_A01 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create a ServerSocket on port 8080
            serverSocket = new ServerSocket(8080);

            System.out.println("Waiting for client...");

            // Accept a connection from a client
            socket = serverSocket.accept();

            System.out.println("Connected!");

            // Get the output stream from the socket
            OutputStream outputStream = socket.getOutputStream();

            // Send a message to the client
            outputStream.write("Hello from Server!".getBytes());

            // Close the connection
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}