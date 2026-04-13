import java.io.*;
import java.net.*;

public class java_38555_SocketServer_A08 {

    public static void main(String[] args) throws Exception {

        // Creating server socket
        ServerSocket serverSocket = new ServerSocket(8000);

        System.out.println("Waiting for client on port: " + 8000);

        // Accepting client connection
        Socket clientSocket = serverSocket.accept();

        System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

        // Create output stream to write response
        OutputStream outputStream = clientSocket.getOutputStream();

        // Sending response
        String response = "Hello, Client!\n";
        outputStream.write(response.getBytes());

        // Closing resources
        clientSocket.close();
        serverSocket.close();
    }
}