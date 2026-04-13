import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketChannel;

public class java_24265_SocketServer_A01 {

    private static final int PORT = 8443;
    private static final String SSL_KEYSTORE_LOCATION = "/path/to/keystore.jks";
    private static final String SSL_KEYSTORE_PASSWORD = "password";
    private static final String SSL_TRUSTSTORE_LOCATION = "/path/to/truststore.jks";
    private static final String SSL_TRUSTSTORE_PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        // Setup SSL Server
        SSLServerSocketChannel sslServerSocketChannel = null;
        try {
            sslServerSocketChannel = SSLServerSocketChannel.open();
            sslServerSocketChannel.bind(new InetSocketAddress(PORT));
            sslServerSocketChannel.getChannel().implictlySetNeedClientAuth(true);

            sslServerSocketChannel.getChannel().init(null, null, new javax.net.ssl.SSLSocket(sslServerSocketChannel.accept()).init(null, null, SSL_KEYSTORE_LOCATION, SSL_KEYSTORE_PASSWORD));

            System.out.println("Starting SSL Server on port " + PORT);

            while (true) {
                SocketChannel clientChannel = sslServerSocketChannel.accept();
                executorService.execute(new SocketHandler(clientChannel));
            }
        } finally {
            if (sslServerSocketChannel != null) {
                sslServerSocketChannel.close();
            }
        }
    }

    private static class SocketHandler implements Runnable {
        private final SocketChannel socketChannel;

        SocketHandler(SocketChannel socketChannel) {
            this.socketChannel = socketChannel;
        }

        @Override
        public void run() {
            // Process the client here
        }
    }
}