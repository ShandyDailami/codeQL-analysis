import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_24217_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            // Set up SSLServerSocket
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(10000);

            // Accept a client
            clientSocket = (SSLSocket) serverSocket.accept();

            // Set up buffers
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Send a welcome message
            out.writeUTF("Welcome to the server!");

            // Get a message from the client
            String message = in.readLine();
            System.out.println("Client: " + message);

            // Close the connection
            clientSocket.close();
        } finally {
            if (serverSocket != null) serverSocket.close();
        }
    }
}