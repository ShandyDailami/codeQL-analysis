import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_21682_SocketServer_A08 {

    private static final String SSL_PORT = "9999";
    private static SSLServerSocket sslServerSocket;
    private static SSLServerSocketFactory sslServerSocketFactory;

    private static final String KEYSTORE_LOCATION = "/path/to/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String KEY_PASSWORD = "password";

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        sslServerSocketFactory = (SSLServerSocketFactory) sslServerSocket.getSocketFactory();

        sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(Integer.parseInt(SSL_PORT));
        sslServerSocket.setNeedClientAuth(true);

        SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
        clientSocket.startHandshake();

        // Perform security sensitive operations, e.g., integrity failure.

        clientSocket.close();
        sslServerSocket.close();
        executorService.shutdown();
    }
}