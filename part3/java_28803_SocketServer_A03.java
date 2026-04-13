import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28803_SocketServer_A03 {
    private static final String SSL_KEYSTORE_LOCATION = "keystore.jks";
    private static final String SSL_KEYSTORE_PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = getSSLServerSocketFactory();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuthentication(true);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");
                SSLSocket sslSocket = (SSLSocket) socket.createChannel(socket.getInetAddress());
                sslSocket.setNeedClientAuthentication(true);

                // Start Handling the request and response here
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    private static SSLServerSocketFactory getSSLServerSocketFactory() throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(SSL_KEYSTORE_LOCATION), SSL_KEYSTORE_PASSWORD.toCharArray());

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, SSL_KEYSTORE_PASSWORD.toCharArray());

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);

            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocketFactory.setKeyManager(keyManagerFactory);
            sslServerSocketFactory.setTrustManager(trustManagerFactory);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sslServerSocketFactory;
    }
}