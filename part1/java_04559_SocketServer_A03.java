import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_04559_SocketServer_A03 {
    private static final String CLIENT_CERT_PATH = "/path/to/client/cert.pem";
    private static final String KEY_STORE_PATH = "/path/to/keystore.jks";
    private static final String KEY_STORE_PASSWORD = "password";
    private static final String TRUST_STORE_PATH = "/path/to/truststore.jks";
    private static final String TRUST_STORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream(KEY_STORE_PATH), KEY_STORE_PASSWORD.toCharArray());

            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(new FileInputStream(TRUST_STORE_PATH), TRUST_STORE_PASSWORD.toCharArray());

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, KEY_STORE_PASSWORD.toCharArray());

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(trustStore);

            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.builder(serverSocket)
                    .keyManager(keyManagerFactory)
                    .trustManager(trustManagerFactory)
                    .build();

            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(1234);
            clientSocket = (SSLSocket) serverSocket.accept();

            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);

            writer.println("Hello, client!");
        } finally {
            clientSocket.close();
            serverSocket.close();
        }
    }
}