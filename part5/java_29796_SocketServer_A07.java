import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_29796_SocketServer_A07 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            // Create a SSLServerSocket
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);

            // Accept a client socket
            clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Send welcome message
            out.writeUTF("Welcome to the Secure Socket Server!\n");

            // Close the input and output streams
            out.close();
            in.close();

            // Close the client socket
            clientSocket.close();
        } finally {
            // Close the server socket
            if (serverSocket != null) serverSocket.close();
        }
    }
}