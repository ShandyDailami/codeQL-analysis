import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_07335_SocketServer_A07 {

    private static SSLServerSocket serverSocket;

    public static void main(String[] args) throws Exception {
        int port = 8888;

        // Create SSLServerSocket and wrap it with SSLSocket
        SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(port);
        serverSocket.setNeedClientAuth(true);

        // Enable client authentication
        serverSocket.setEnabledClientAuthSites(null);
        serverSocket.setEnabledSites(null);

        System.out.println("Waiting for client authentication");

        // Accept client connection
        SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
        clientSocket.startHandshake();

        // Perform authentication here
        // ...

        // Create input and output streams
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // Send a message to the client
        out.println("Hello, client, you are authenticated!");

        // Close the connection
        clientSocket.close();
        serverSocket.close();
    }
}