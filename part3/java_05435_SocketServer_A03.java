import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_05435_SocketServer_A03 {
    private static final String KEYSTORE_TYPE = "JKS";
    private static final String KEYSTORE_PATH = "path/to/your/keystore"; // replace with your keystore path
    private static final String KEYSTORE_PASSWORD = "your_keystore_password"; // replace with your keystore password
    private static final String TRUSTSTORE_PATH = "path/to/your/truststore"; // replace with your truststore path
    private static final String TRUSTSTORE_PASSWORD = "your_truststore_password"; // replace with your truststore password

    public static void main(String[] args) throws IOException, KeyManagementException, CertificateException, KeyStoreException {
        SSLContext sslContext = getSSLContext(KEYSTORE_TYPE, KEYSTORE_PATH, KEYSTORE_PASSWORD, TRUSTSTORE_PATH, TRUSTSTORE_PASSWORD);

        ServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) sslContext.getServerSocket(5000);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) clientSocket.getSocket();
                sslSocket.setNeedClientAuthentication(true);
                sslSocket.setUseClientMode(true);
                sslSocket.startHandshake();
                // process the client
                new ClientHandler(sslSocket).start();
            }
        } finally {
            serverSocket.close();
        }
    }

    private static SSLContext getSSLContext(String keyStoreType, String keyStorePath, String keyStorePassword, String trustStorePath, String trustStorePassword) throws KeyStoreException, IOException, CertificateException, KeyManagementException {
        KeyStore keyStore = KeyStore.getInstance(keyStoreType);
        char[] keyStorePasswordChar = keyStorePassword.toCharArray();
        InputStream keyStoreInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(keyStorePath);
        keyStore.load(keyStoreInputStream, keyStorePasswordChar);

        KeyStore trustStore = KeyStore.getInstance(keyStoreType);
        char[] trustStorePasswordChar = trustStorePassword.toCharArray();
        InputStream trustStoreInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(trustStorePath);
        trustStore.load(trustStoreInputStream, trustStorePasswordChar);

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, keyStorePasswordChar);

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(trustStore);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory, trustManagerFactory, null);

        return sslContext;
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_05435_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // handle client
        }
    }
}