import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_35443_SocketServer_A01 {

    private static final int PORT = 12345;
    private static final String KEYSTORE_LOCATION = "/path/to/your/keystore";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String TRUSTSTORE_LOCATION = "/path/to/your/truststore";
    private static final String TRUSTSTORE_PASSWORD = "your_truststore_password";

    private SSLServerSocket serverSocket;
    private ExecutorService executor;

    public void start() throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
        serverSocket.setNeedClientAuth(true);

        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(ClassLoader.getSystemResourceAsStream(KEYSTORE_LOCATION), KEYSTORE_PASSWORD.toCharArray());

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, KEYSTORE_PASSWORD.toCharArray());

        TrustStore trustStore = TrustStore.getInstance("JKS");
        trustStore.load(ClassLoader.getSystemResourceAsStream(TRUSTSTORE_LOCATION), TRUSTSTORE_PASSWORD.toCharArray());

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory, trustStore, null);

        serverSocket.setSSLSocketFactory(sslContext.getSocketFactory());

        executor = Executors.newFixedThreadPool(5);

        while (true) {
            Socket client = serverSocket.accept();
            executor.execute(new ClientHandler(client));
        }
    }

    public static void main(String[] args) throws IOException {
        SecureSocketServer server = new SecureSocketServer();
        server.start();
    }

    private static class ClientHandler implements Runnable {
        private Socket client;

        public java_35443_SocketServer_A01(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                // Handle client communication here
                // ...

            } finally {
                client.close();
            }
        }
    }
}