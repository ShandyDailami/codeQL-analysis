import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_01076_SocketServer_A01 {

    private static SSLServerSocket serverSocket;

    public static void main(String[] args) throws IOException {

        // Setup the SSL server socket
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(5000);
        serverSocket.setNeedClientAuthentication(true);
        serverSocket.setEnabledCipherSuites(sslServerSocketFactory.getSupportedCipherSuites());

        // Accept new connections
        SSLSocket clientSocket = (SSLSocket) serverSocket.accept();

        // Get the input and output streams
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // Send a welcome message
        out.println("Welcome to the Secure Socket Server!");

        // Read a message from the client
        String message = in.readLine();
        System.out.println("Client says: " + message);

        // Close the client and server sockets
        clientSocket.close();
        serverSocket.close();
    }
}