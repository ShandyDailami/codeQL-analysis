import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.security.Key;
import java.security.KeyStore;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.KeyManagerFactory;

public class java_24764_SocketServer_A08 {

    private static final String SERVER_KEYSTORE = "server.keystore";
    private static final String SERVER_KEYSTORE_PASSWORD = "password";
    private static final String CLIENT_KEY = "client";
    private static final String TRUSTSTORE = "truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        int port = 8080;

        // Create a keystore and truststore for client
        KeyStore clientKeystore = KeyStore.getInstance("JKS");
        clientKeystore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(CLIENT_KEY), SERVER_KEYSTORE_PASSWORD.toCharArray());

        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(clientKeystore, SERVER_KEYSTORE_PASSWORD.toCharArray());

        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(TRUSTSTORE), TRUSTSTORE_PASSWORD.toCharArray());

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory.setKeyStore(clientKeystore);
        sslServerSocketFactory.setKeyStorePassword(SERVER_KEYSTORE_PASSWORD);
        sslServerSocketFactory.setTrustStore(trustStore);
        sslServerSocketFactory.setTrustStorePassword(TRUSTSTORE_PASSWORD);

        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);

        while (true) {
            Socket clientSocket = sslServerSocket.accept();
            SSLSocket sslSocket = (SSLSocket) sslServerSocketFactory.createSocket(clientSocket, clientSocket.getInetAddress(), true, false);

            OutputStream out = sslSocket.getOutputStream();
            out.write(("Hello, client! \n").getBytes());
            sslSocket.close();
        }
    }
}