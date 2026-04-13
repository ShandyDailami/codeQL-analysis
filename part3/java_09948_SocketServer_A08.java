import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_09948_SocketServer_A08 {
    private static final int PORT = 8888;
    private static final String KEYSTORE_LOCATION = "/path/to/your/keystore";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String KEY_PASSWORD = "your_key_password";
    private static final String SSL_PROTOCOL = "TLS";

    public static void main(String[] args) throws Exception {
        KeyStore keystore = KeyStore.getInstance("JKS");
        try (InputStream keystoreStream = new java.util.Scanner(
                new java.io.FileInputStream(KEYSTORE_LOCATION)).useDelimiter("\\Z").next()) {
            keystore.load(keystoreStream, KEYSTORE_PASSWORD.toCharArray());
        }

        SSLServerSocketFactory sslServerSocketFactory =
                (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
        sslServerSocket.setNeedClientAuth(true);
        sslServerSocket.setKeyStore(keystore);
        sslServerSocket.setKeyStorePassword(KEYSTORE_PASSWORD);

        ExecutorService executorService = Executors.newCachedThreadPool();

        while (true) {
            try (SSLSocket socket = (SSLSocket) sslServerSocket.accept()) {
                socket.setNeedClientAuth(true);
                System.out.println("New Connection: " + socket.getRemoteSocketAddress());
                OutputStream out = socket.getOutputStream();
                InputStream in = socket.getInputStream();

                executorService.execute(new SocketHandler(in, out));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class SocketHandler implements Runnable {
        private final InputStream in;
        private final OutputStream out;

        SocketHandler(InputStream in, OutputStream out) {
            this.in = in;
            this.out = out;
        }

        @Override
        public void run() {
            // TODO: Handle requests, error handling, and security failures
            // You should generate code here to implement this
        }
    }
}