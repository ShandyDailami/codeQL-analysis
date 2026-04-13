import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;

public class java_40417_SocketServer_A07 {

    private static final String SSL_KEY_STORE = "path-to-your-keystore";
    private static final String SSL_KEY_STORE_PASSWORD = "password-of-your-keystore";
    private static final String SSL_TRUST_STORE = "path-to-your-truststore";
    private static final String SSL_TRUST_STORE_PASSWORD = "password-of-your-truststore";
    private static final String SSL_KEY_ALIAS = "alias-of-your-key";

    public static void main(String[] args) throws Exception {

        SSLContext sslContext = getSSLContext(SSL_KEY_STORE, SSL_KEY_STORE_PASSWORD,
                SSL_TRUST_STORE, SSL_TRUST_STORE_PASSWORD, SSL_KEY_ALIAS);

        ServerSocket serverSocket = null;

        try {
            serverSocket = (ServerSocket) sslContext.getServerSocket(4444);
            System.out.println("Server started on port 4444");

            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected");

                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream();

                BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println("Received: " + line);
                    outputStream.write(("Server: " + line).getBytes());
                    outputStream.newLine();
                    outputStream.flush();
                }
                clientSocket.close();
            }
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    private static SSLContext getSSLContext(String keystorePath, String keystorePassword,
                                             String truststorePath, String truststorePassword,
                                             String keyAlias) throws Exception {
        KeyManagerFactory keyManagerFactory = getKeyManagerFactory(keystorePath, keystorePassword);
        TrustManagerFactory trustManagerFactory = getTrustManagerFactory(truststorePath, truststorePassword);

        return SSLContext.getInstance("SSL");
    }

    private static KeyManagerFactory getKeyManagerFactory(String keystorePath, String keystorePassword) throws Exception {
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunKS");
        keyManagerFactory.init(new java.security.KeyStoreInputStream(keystorePath, keystorePassword.toCharArray()),
                keystorePassword.toCharArray());
        return keyManagerFactory;
    }

    private static TrustManagerFactory getTrustManagerFactory(String truststorePath, String truststorePassword) throws Exception {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunJSSE");
        trustManagerFactory.init(new java.security.KeyStoreInputStream(truststorePath, truststorePassword.toCharArray()));
        return trustManagerFactory;
    }
}