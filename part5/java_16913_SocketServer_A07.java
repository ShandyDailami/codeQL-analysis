import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_16913_SocketServer_A07 {
    private static final String CLIENT_IDENTIFIER = "CLIENT_IDENTIFIER";

    public static void main(String[] args) throws Exception {
        int port = 1234;
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
            sslServerSocket.setNeedClientAuth(true);

            // Start accepting clients
            while (true) {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                sslSocket.setNeedClientAuth(true);

                // Get client certificate
                X509Certificate cert = (X509Certificate) sslSocket.getSession().getPeerCertificate();
                System.out.println("Client certificate: " + cert.getSubjectDN().toString());

                // Authenticate client
                sslSocket.setNeedClientAuth(true);
                sslSocket.startHandshake();

                // Check if client authentication was successful
                if (!sslSocket.getNeedClientAuth()) {
                    System.out.println("Authentication failed!");
                    continue;
                }

                // Connection successful, print client information
                System.out.println("Client information: " + sslSocket.getRemoteSocketAddress().toString());
           
                // Send response
                DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());
                out.writeUTF("Successfully connected");

                // Close connection
                sslSocket.close();
            }
        } finally {
            serverSocket.close();
            sslServerSocket.close();
        }
    }
}