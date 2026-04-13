import java.net.*;
import java.io.*;
import java.security.*;

public class java_36608_SocketServer_A03 {
    public static void main(String[] args) throws IOException, SSLException {
        SSLServerSocket serverSocket = null;
        try {
            // Create a SSLServerSocket
            SSLServerSocket server = new SSLServerSocket(8080);
            serverSocket = server;

            while (true) {
                // Accept a connection
                SSLSocket clientSocket = server.accept();

                // Get the input and output streams
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                // Send a welcome message
                out.writeBytes("Welcome to the Socket Server!\n");

                // Close the connection
                clientSocket.close();
            }
        } finally {
            // Clean up
            serverSocket.close();
        }
    }
}