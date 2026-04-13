import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLServerSocketChannel;
import javax.net.ssl.SSLContext;

public class java_28614_SocketServer_A01 {

    private static final int POOL_SIZE = 5;

    public static void main(String[] args) throws IOException {
        // Create SSLContext with the certificates
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new String[]{"ssl/server.jks"}, null);

        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

        // Create a ServerSocketChannel that uses SSL
        ServerSocketChannel serverSocketChannel = sslContext.getServerSocketChannel();
        serverSocketChannel.bind(new InetSocketAddress(8443));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server started on port 8443");

        while (true) {
            SocketChannel client = serverSocketChannel.accept();
            if (client != null) {
                executor.execute(new SocketHandler(client));
            }
        }
    }

    static class SocketHandler implements Runnable {
        SocketChannel client;

        SocketHandler(SocketChannel client) {
            this.client = client;
        }

        @Override
        public void run() {
            // Handle the client here...
        }
    }
}