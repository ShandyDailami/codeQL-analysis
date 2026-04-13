import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_02082_SocketServer_A03 {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8000;
    private static final String CLIENT_HOST = "127.0.0.1";

    public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException, IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        sslServerSocketFactory.setEndpointIdentificationAlgorithm("SHA-1");

        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(new InetSocketAddress(SERVER_HOST, SERVER_PORT), 1000, 10000, true, true);
        sslServerSocket.setNeedClientAuth(true);
        sslServerSocket.setEnabledProtocols(new String[]{"TLSv1.2"});

        System.out.println("Waiting for client on port " + sslServerSocket.getLocalPort() + " ...");

        SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
        clientSocket.setNeedClientAuth(true);

        System.out.println("Connection accepted from " + clientSocket.getRemoteSocketAddress());

        // Close the server socket and client socket here
        clientSocket.close();
        sslServerSocket.close();
    }
}