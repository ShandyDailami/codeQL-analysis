import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.cert.Certificate;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class java_41720_SocketServer_A01 {
    private static final String SERVER_KEYSTORE = "server.jks";
    private static final String SERVER_ALIAS = "server";
    private static final String CLIENT_KEYSTORE = "client.jks";
    private static final String CLIENT_ALIAS = "client";

    public static void main(String[] args) throws Exception {
        // Load server's certificate and private key
        Certificate serverCertificate = CertificateLoader.loadCertificate(SERVER_KEYSTORE, SERVER_ALIAS);

        // Create server's SSLSocketFactory using the server's certificate and private key
        SSLSocketFactory sslServerSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        sslServerSocketFactory.setEndpointIdentities(serverCertificate);

        // Create server's SSLServerSocket
        SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(5000);
        serverSocket.setNeedClientAuth(true);

        // Accept client connections
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Create client's SSLSocket
            SSLSocket sslSocket = (SSLSocket) clientSocket.getSocket();
            sslSocket.setUseClientMode(true);

            // Verify client's certificate
            Certificate clientCertificate = CertificateLoader.loadCertificate(CLIENT_KEYSTORE, CLIENT_ALIAS);
            sslSocket.setNeedClientAuth(true);
            sslSocket.verify(clientCertificate);
            System.out.println("Client's certificate verified");

            // ... rest of your code here ...
        }
    }
}