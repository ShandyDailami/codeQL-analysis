import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManagerFactory;

public class java_07549_SocketServer_A08 {

    private static final String SSL_KEY_STORE = "server.jks";
    private static final String SSL_KEY_STORE_PASSWORD = "password";
    private static final String SSL_TRUST_STORE = "client.jks";
    private static final String SSL_TRUST_STORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;

        try {
            // Create a server socket using SSL
            SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);

            // Create a key store for the server
            KeyStore serverKeyStore = KeyStore.getInstance("JKS");
            serverKeyStore.load(new java.security.cert.CertificateRequest(null, null, null, null, null),
                    SSL_KEY_STORE_PASSWORD.toCharArray());

            // Create a key store for the client
            KeyStore clientKeyStore = KeyStore.getInstance("JKS");
            clientKeyStore.load(new java.security.cert.CertificateRequest(null, null, null, null, null),
                    SSL_TRUST_STORE_PASSWORD.toCharArray());

            // Create a trust manager factory
            TrustManagerFactory trustManagerFactory = TrustManagerFactory
                    .getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(new java.security.cert.CertificateRequest(null, null, null, null, null));

            // Set up the server socket
            serverSocket = (ServerSocket) sslServerSocket;
            serverSocket.setSoTimeout(10000);

            while (true) {
                Socket socket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) socket.createChannel();
                sslSocket.setUseClientMode(true);
                sslSocket.setNeedClientAuth(true);

                // Setup the SSL socket
                sslSocket.startHandshake();

                sslSocket.setSSLServerSocket((SSLServerSocket) serverSocket);
                sslSocket.setKeyStore(serverKeyStore);
                sslSocket.setTrustStore(clientKeyStore);
                sslSocket.setTrustManagerFactory(trustManagerFactory);

                // Write to the socket
                OutputStream out = sslSocket.getOutputStream();
                out.write("Hello, client!\r\n".getBytes());
                out.flush();

                sslSocket.close();
            }
        } catch (CertificateException | IOException e) {
            e.printStackTrace();
        }
    }
}