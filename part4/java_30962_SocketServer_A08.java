import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.security.Key;
import java.security.KeyStore;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class java_30962_SocketServer_A08 {

    private static final String KEYSTORE = "keys/client.keystore";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String TRUSTSTORE = "keys/truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "password";
    private static final String ALGORITHM = "SunEC";

    public static void main(String[] args) throws Exception {
        runServer(8080, KEYSTORE, KEYSTORE_PASSWORD, TRUSTSTORE, TRUSTSTORE_PASSWORD, ALGORITHM);
    }

    public static void runServer(int port, String keystoreFile, String keystorePassword, String truststoreFile, String truststorePassword, String algorithm) throws Exception {
        ServerSocket socket = null;
        try {
            socket = createSSLServerSocket(port, keystoreFile, keystorePassword, truststoreFile, truststorePassword, algorithm);
            while (true) {
                Socket clientSocket = socket.accept();
                processRequest(clientSocket);
            }
        } finally {
            socket.close();
        }
    }

    private static SSLServerSocket createSSLServerSocket(int port, String keystoreFile, String keystorePassword, String truststoreFile, String truststorePassword, String algorithm) throws Exception {
        SSLServerSocket socket = null;
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(keystoreFile), keystorePassword.toCharArray());

            TrustManagerFactory tmf = TrustManagerFactory.getInstance(algorithm);
            tmf.init(new KeyStoreTrustManager(keyStore));
            TrustManager[] trustManagers = tmf.getTrustManagers();

            SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(port, null, trustManagers, keyStore);

            sslServerSocket.setNeedClientAuth(true);
            sslServerSocket.setCertificateTrustManager(new CertificateTrustManager());
            sslServerSocket.setKeyStore(keyStore, keystorePassword.toCharArray());

            return sslServerSocket;
        } finally {
            return socket;
        }
    }

    private static void processRequest(Socket socket) {
        // Implement processRequest method to handle socket connection
    }

    private static class KeyStoreTrustManager implements TrustManager {

        private KeyStore trustStore;

        public java_30962_SocketServer_A08(KeyStore trustStore) {
            this.trustStore = trustStore;
        }

        @Override
        public boolean checkClientTrusted(X509Certificate[] chain, String authType) {
            return true;
        }

        @Override
        public boolean checkServerTrusted(X509Certificate[] chain, String authType) {
            return true;
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

    }

    private static class CertificateTrustManager implements javax.net.ssl.X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

    }
}