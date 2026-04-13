import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.PasswordAuthentication;

public class java_14284_SocketServer_A01 {
    private static final String KEY_STORE = "client.keystore";
    private static final char[] KEY_STORE_PASSWORD = "password".toCharArray();
    private static final String TRUST_STORE = "client.truststore";
    private static final char[] TRUST_STORE_PASSWORD = "password".toCharArray();
    private static final String SSL_PROTOCOL = "TLSv1.2";

    public static void main(String[] args) throws CertificateException, IOException {
        SSLContext sslContext = getSSLContext(KEY_STORE, KEY_STORE_PASSWORD,
                TRUST_STORE, TRUST_STORE_PASSWORD, SSL_PROTOCOL);
        SSLServerSocket serverSocket = (SSLServerSocket) sslContext.getServerSocket(8000);

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Connection established with client: " + clientSocket.getRemoteSocketAddress());

            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();

            byte[] buffer = new byte[1024];
            int length = input.read(buffer);

            String message = new String(buffer, 0, length);
            System.out.println("Received message: " + message);

            String response = "Hello, client!";
            output.write(response.getBytes());
            clientSocket.close();
        }
    }

    private static SSLContext getSSLContext(String keyStoreFile, char[] keyStorePassword,
                                            String trustStoreFile, char[] trustStorePassword,
                                            String sslProtocol) throws CertificateException, IOException {
        KeyManagerFactory keyManagerFactory = getKeyManagerFactory(keyStoreFile, keyStorePassword);
        TrustManagerFactory trustManagerFactory = getTrustManagerFactory(trustStoreFile, trustStorePassword);

        SSLContext sslContext = SSLContext.getInstance(sslProtocol);
        sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
        return sslContext;
    }

    private static KeyManagerFactory getKeyManagerFactory(String keyStoreFile, char[] keyStorePassword)
            throws IOException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(getClass().getResourceAsStream(keyStoreFile), keyStorePassword);

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyStore.getDefaultType());
        keyManagerFactory.init(keyStore, keyStorePassword);
        return keyManagerFactory;
    }

    private static TrustManagerFactory getTrustManagerFactory(String trustStoreFile, char[] trustStorePassword)
            throws IOException, CertificateException {
        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(getClass().getResourceAsStream(trustStoreFile), trustStorePassword);

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(KeyStore.getDefaultType());
        trustManagerFactory.init(trustStore);
        return trustManagerFactory;
    }
}