import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_25494_SocketServer_A01 {
    private static final String CLIENT_IDENTIFIER = "CLIENT_IDENTIFIER";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            // Create an SSLServerSocket for the server to listen on.
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            serverSocket.setNeedClientAuth(true);
            serverSocket.setCertificateExtensions("SSL-Client-Session-ID:" + CLIENT_IDENTIFIER);

            System.out.println("Waiting for client on port 12345...");

            // Accept client connection.
            clientSocket = (SSLSocket) serverSocket.accept();

            System.out.println("Client connected!");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Write an encrypted message.
            out.writeBytes("Hello Client, Welcome to Secure Connection!\n");

            // Close the connection.
            clientSocket.close();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}