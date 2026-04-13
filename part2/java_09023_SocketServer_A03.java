import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.net.ssl.*;

public class java_09023_SocketServer_A03 {
    private static final String KEYSTORE_LOCATION = "/path/to/your/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String KEY_PASSWORD = "your_key_password";
    private static final String SSL_TRUSTSTORE_LOCATION = "/path/to/your/truststore.jks";
    private static final String SSL_TRUSTSTORE_PASSWORD = "your_truststore_password";

    private ExecutorService executor;
    private ServerSocketChannel serverSocketChannel;

    public java_09023_SocketServer_A03() {
        executor = Executors.newFixedThreadPool(10);
    }

    public void startServer(int port) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocketChannel = (ServerSocketChannel) sslServerSocketFactory.createServerSocket(port, 5000);
            serverSocketChannel.bind(new InetSocketAddress(port));
            serverSocketChannel.configureBlocking(false);

            System.out.println("Server started on port: " + port);

            while (true) {
                SecureSocketChannel clientSocketChannel = (SecureSocketChannel) serverSocketChannel.accept();
                executor.execute(new SocketHandler(clientSocketChannel));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
            try {
                serverSocketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class SocketHandler implements Runnable {
        private final SocketChannel socketChannel;

        public java_09023_SocketServer_A03(SocketChannel socketChannel) {
            this.socketChannel = socketChannel;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socketChannel.socket().getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String inputLine;
                while ((inputLine = reader.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                    // Here is the point of A03_Injection.
                    // We can inject code here that is not secure.
                    // For example:
                    // String injection = "Your input here";
                    // System.out.println("Injected: " + injection);
                }

                socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SecureServer server = new SecureServer();
        server.startServer(4444);
    }
}