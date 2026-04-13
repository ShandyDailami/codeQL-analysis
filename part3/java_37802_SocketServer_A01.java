import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_37802_SocketServer_A01 {
    private static final int THREAD_COUNT = 10;
    private ExecutorService executor;
    private ServerSocketChannel serverSocketChannel;

    public java_37802_SocketServer_A01(int port) throws IOException {
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);

        executor = Executors.newFixedThreadPool(THREAD_COUNT);
    }

    public void start() throws IOException {
        System.out.println("Server is listening on port " + serverSocketChannel.socket().getLocalPort());

        while (true) {
            SocketChannel clientChannel = serverSocketChannel.accept();
            if (clientChannel != null) {
                System.out.println("Accepted connection from " + clientChannel.socket().getRemoteSocketAddress());

                final SocketChannel finalClientChannel = clientChannel;
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        handleClient(finalClientChannel);
                    }
                });
            }
        }
    }

    private void handleClient(SocketChannel clientChannel) {
        // Handle the client here. This is where you can add code to secure the client.
    }

    public static void main(String[] args) throws IOException {
        SecureSocketServer server = new SecureSocketServer(8080);
        server.start();
    }
}