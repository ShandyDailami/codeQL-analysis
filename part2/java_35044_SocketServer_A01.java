import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_35044_SocketServer_A01 {

    private static final int PORT = 8080;
    private static final String SSL_SERVER_KEYSTORE = "server.jks";
    private static final String SSL_SERVER_KEYSTORE_PASSWORD = "password";
    private static final String SSL_CLIENT_KEYSTORE = "client.jks";
    private static final String SSL_CLIENT_KEYSTORE_PASSWORD = "password";

    private SSLServerSocket serverSocket;
    private ExecutorService executorService;

    public void start() {
        executorService = Executors.newFixedThreadPool(5);
        try {
            SSLServerSocketFactory sslServerSocketFactory = createSSLServerSocketFactory();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                executorService.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
            executorService.shutdown();
        }
    }

    private SSLServerSocketFactory createSSLServerSocketFactory() throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = null;
        KeyStore clientKeyStore = createKeyStore(SSL_CLIENT_KEYSTORE, SSL_CLIENT_KEYSTORE_PASSWORD);
        KeyStore serverKeyStore = createKeyStore(SSL_SERVER_KEYSTORE, SSL_SERVER_KEYSTORE_PASSWORD);
        KeyManagerFactory keyManagerFactory = createKeyManagerFactory(serverKeyStore, SSL_SERVER_KEYSTORE_PASSWORD);
        TrustManagerFactory trustManagerFactory = createTrustManagerFactory(clientKeyStore, SSL_CLIENT_KEYSTORE_PASSWORD);
        sslServerSocketFactory = new SSLServerSocketFactory(trustManagerFactory, keyManagerFactory);
        return sslServerSocketFactory;
    }

    private KeyStore createKeyStore(String keyStoreFile, String password) throws IOException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(getClass().getResourceAsStream(keyStoreFile), password.toCharArray());
        return keyStore;
    }

    private KeyManagerFactory createKeyManagerFactory(KeyStore keyStore, String password) throws IOException {
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, password.toCharArray());
        return keyManagerFactory;
    }

    private TrustManagerFactory createTrustManagerFactory(KeyStore keyStore, String password) throws IOException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        return trustManagerFactory;
    }

    private class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_35044_SocketServer_A01(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        public void run() {
            try {
                SSLServerSocket sslServerSocket = (SSLServerSocket) serverSocket.accept();
                SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
                // Here you can add your logic, for example reading from client and sending response
                // ...
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new SecureSocketServer().start();
    }
}