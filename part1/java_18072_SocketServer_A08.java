import java.net.*;
import java.io.*;
import javax.net.ssl.*;

public class java_18072_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        try {
            // Create an SSLServerSocket to listen on port 12345
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            serverSocket.setNeedClientAuth(true);

            // Accept a client connection
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Client connected");

            // Create an input stream to read from the client
            InputStream input = clientSocket.getInputStream();

            // Create a writer to write back to the client
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            // Write a message to the client
            writer.println("Hello, client!");

            // Close the connection
            clientSocket.close();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}