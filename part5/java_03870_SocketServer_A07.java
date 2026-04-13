import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;

public class java_03870_SocketServer_A07 {

    private static final int PORT = 12345;
    private static final String KEYSTORE_LOCATION = "/path/to/your/keystore";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String KEY_PASSWORD = "your_key_password";

    public static void main(String[] args) throws IOException {

        SSLContext sslContext = getSSLContext();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ServerSocket serverSocket = null;

        try {
            serverSocket = (SSLServerSocket) sslContext.getServerSocket(PORT);
            serverSocket.setReuseAddress(true);

            while (true) {
                final SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                clientSocket.setSoTimeout(60 * 1000);

                executorService.execute(new Runnable() {
                    public void run() {
                        handleRequest(clientSocket);
                    }
                });
            }
        } finally {
            executorService.shutdown();
            serverSocket.close();
        }
    }

    private static void handleRequest(SSLSocket clientSocket) {
        // Handle client request here
    }

    private static SSLContext getSSLContext() throws IOException {
        SSLContext sslContext = SSLContext.getInstance("SSL");

        sslContext.init(
            new KeyStoreInputStream(KEYSTORE_LOCATION, KEYSTORE_PASSWORD.toCharArray()),
            new KeyManager[] { new KeyManager(KEY_PASSWORD) },
            new TrustManager[] { new TrustManager() }
        );

        return sslContext;
    }
}