import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class java_15486_SocketServer_A03 {

    private static final int THREADS = 5;

    public static void main(String[] args) throws IOException {
        Executor executor = Executors.newFixedThreadPool(THREADS);
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.socket().bind(new InetSocketAddress(8080));

        serverChannel.configureBlocking(false);

        System.out.println("Server is listening on port 8080");

        ByteBuffer buffer = ByteBuffer.allocate(16);

        while (true) {
            SocketChannel clientChannel = serverChannel.accept();
            if (clientChannel != null) {
                System.out.println("Accepted connection from " + clientChannel);
                clientChannel.configureBlocking(false);

                executor.execute(new SocketHandler(clientChannel, buffer));
            }
        }
    }

    static class SocketHandler implements Runnable {
        private final SocketChannel clientChannel;
        private final ByteBuffer buffer;

        SocketHandler(SocketChannel clientChannel, ByteBuffer buffer) {
            this.clientChannel = clientChannel;
            this.buffer = buffer;
        }

        @Override
        public void run() {
            try {
                buffer.clear();
                clientChannel.read(buffer);

                if (buffer.hasRemaining()) {
                    System.out.println("Received: " + buffer.flip().asReadableByteBuffer());
                    clientChannel.write(buffer);
                }
            } catch (IOException ex) {
                System.out.println("Exception caught in I/O: " + ex);
            }
        }
    }
}