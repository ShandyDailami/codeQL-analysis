import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_23533_SocketServer_A08 {

    private static final int PORT = 8080;
    private static final String HOST = "localhost";

    private static final int MAX_THREADS = 10;
    private static final int BUFSIZE = 1024;

    private static ByteBuffer buffer = ByteBuffer.allocate(BUFSIZE);

    public static void main(String[] args) throws IOException {

        ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREADS);

        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(HOST, PORT));
        serverChannel.configureBlocking(false);

        System.out.println("Server is listening on " + HOST + ":" + PORT);

        while (true) {
            SocketChannel clientChannel = serverChannel.accept();
            if (clientChannel != null) {
                System.out.println("Accepted connection from " + clientChannel);
                executorService.execute(new SocketHandler(clientChannel));
            }
        }
    }

    static class SocketHandler implements Runnable {

        SocketChannel clientChannel;

        SocketHandler(SocketChannel clientChannel) {
            this.clientChannel = clientChannel;
        }

        @Override
        public void run() {

            try {
                while ((clientChannel.read(buffer)) > 0) {
                    buffer.flip();
                    // Perform security-sensitive operations related to A08_IntegrityFailure
                    // ...
                    buffer.clear();
                }

                clientChannel.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}