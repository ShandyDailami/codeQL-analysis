import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_23483_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            // Create an SSLServerSocket for accepting secure connections
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            serverSocket.setNeedClientAuth(true);
            serverSocket.setEnabledProtocols(new String[] {SSLConnection.TLSv1, SSLConnection.TLSv1_1, SSLConnection.TLSv1_2});

            // Accept a client connection
            clientSocket = (SSLSocket) serverSocket.accept();

            // Write out a welcome message
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Welcome to the Secure Server!");

            // Read an encrypted message from the client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message = in.readLine();

            // Echo back to client
            out.println(message);
        } finally {
            // Cleanup
            clientSocket.close();
            serverSocket.close();
        }
    }
}