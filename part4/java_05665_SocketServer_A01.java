import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_05665_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            // Create a KeyPair and a SSLServerSocket
            KeyPair keyPair = KeyPairUtil.generateKeyPair();
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080, null, keyPair.getPrivate());

            // Server starts listening for client connections
            System.out.println("Waiting for client connection on port 8080...");

            // Accept client connection
            clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.startHandshake();

            // Print out the client's IP address and port number
            System.out.println("Connected to " + clientSocket.getRemoteSocketAddress().toString());

            // Send a welcome message to the client
            OutputStream outToClient = clientSocket.getOutputStream();
            PrintWriter out = new PrintWriter(outToClient, true);
            out.println("Welcome to the server!");

            // Close the client socket
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the server socket
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}