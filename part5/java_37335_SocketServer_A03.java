import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_37335_SocketServer_A03 {
    private static final int PORT = 12345;
    private static final String KEYSTORE_LOCATION = "/path/to/your/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "yourpassword";
    private static final String KEY_PASSWORD = "yourpassword";

    private SSLServerSocket serverSocket;
    private ExecutorService executorService;

    public java_37335_SocketServer_A03() {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try {
            sslServerSocketFactory = sslServerSocketFactory.createServerSocketFactory(new SSLServerSocketFactoryContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            serverSocket. setNeedClientAuth(true);

            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(getClass().getResourceAsStream("/keystore.jks"), KEYSTORE_PASSWORD.toCharArray());

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunKSAPI");
            keyManagerFactory.init(keyStore, KEY_PASSWORD.toCharArray());

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagerFactory, trustManagerFactory, new java.security.SecureRandom());

            serverSocket.setSSLEngine(sslContext.getSSLEngine());
        } catch (Exception e) {
            e.printStackTrace();
        }

        executorService = Executors.newFixedThreadPool(10);
    }

    public void start() {
        System.out.println("Server started at port " + PORT);

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                executorService.execute(new SocketHandler(socket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new SocketServer().start();
    }
}