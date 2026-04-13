import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_07084_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            // Create a SSLServerSocket
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            // Accept a client connection
            clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.startHandshake();

            // Write the client's certificate to the server's console
            System.out.println(clientSocket.getLocalCertificate());

            // Close the client socket and server socket
            clientSocket.close();
            serverSocket.close();
        } finally {
            // Clean up the connection if necessary
            if (clientSocket != null)
                clientSocket.close();
            if (serverSocket != null)
                serverSocket.close();
        }
    }
}