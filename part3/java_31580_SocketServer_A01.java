import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_31580_SocketServer_A01 {

    private static final String SSL_PROTOCOL = "TLSv1.2";
    private static final String KEY_STORE = "keystore.jks";
    private static final String KEY_STORE_PASSWORD = "password";
    private static final String TRUST_STORE = "truststore.jks";
    private static final String TRUST_STORE_PASSWORD = "password";

    public static void main(String[] args) {
        SocketServer server = new SocketServer();
        server.start();
    }

    private void start() {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLSocketServerFactory();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(1234);
            serverSocket.setNeedClientAuth(true);
            serverSocket.setEnabledProtocols(new String[] { SSL_PROTOCOL });
            serverSocket.setCertificateExtensions({ new javax.security.auth.DestroyableSSLContext(getSSLContext()).getClientDestroyableExtensions() });
            serverSocket.setNeedClientAuth(true);

            // Load the keystore and truststore
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream(KEY_STORE), KEY_STORE_PASSWORD.toCharArray());

            TrustStore trustStore = TrustStore.getInstance("JKS");
            trustStore.load(new FileInputStream(TRUST_STORE), TRUST_STORE_PASSWORD.toCharArray());

            // Create a new SSL context using our key store and trust store
            SSLContext sslContext = SSLContext.getInstance(SSL_PROTOCOL);
            sslContext.init(keyStore, trustStore, null);
            serverSocket.setSSLSocketFactory(sslContext.getSocketFactory());

            while (true) {
                Socket clientSocket = serverSocket.accept();
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    private void handleClient(Socket clientSocket) {
        // handle client socket
    }
}