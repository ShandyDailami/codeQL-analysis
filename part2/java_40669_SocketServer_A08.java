import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_40669_SocketServer_A08 {
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) {
        System.out.println("Server started");

        try {
            // Create an SSLServerSocket and a socket for incoming connections
            SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            // Accept a client connection
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();

            // Create a new InputStream and OutputStream for the client
            InputStream clientInputStream = clientSocket.getInputStream();
            OutputStream clientOutputStream = clientSocket.getOutputStream();

            // Send a welcome message to the client
            String response = "Welcome to the server!";
            clientOutputStream.write(response.getBytes());

            // Close the client connection
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Server stopped");
    }
}