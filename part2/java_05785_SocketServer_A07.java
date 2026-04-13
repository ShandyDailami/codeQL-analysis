import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_05785_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            // Create SSLServerSocket for server
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            // Accept a client connection
            clientSocket = (SSLSocket) serverSocket.accept();

            // Get the client certificate
            X509Certificate cert = (X509Certificate) clientSocket.getSessionProtocol();
            System.out.println("Client certificate: " + cert.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the SSLServerSocket and the client socket
        if (serverSocket != null) serverSocket.close();
        if (clientSocket != null) clientSocket.close();
    }
}