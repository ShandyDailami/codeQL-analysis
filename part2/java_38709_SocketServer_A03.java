import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;

public class java_38709_SocketServer_A03 {

    private static final int THREADS = 5;
    private static final int BUFFER_SIZE = 1024;

    private final ServerSocketChannel serverSocketChannel;
    private final ExecutorService executorService;
    private final LinkedBlockingQueue<ByteBuffer> buffers = new LinkedBlockingQueue<>(THREADS);

    public java_38709_SocketServer_A03(int port) throws IOException {
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);

        executorService = Executors.newFixedThreadPool(THREADS);

        for (int i = 0; i < THREADS; i++) {
            executorService.execute(new ClientHandler(buffers));
        }
    }

    public void stop() throws IOException {
        serverSocketChannel.close();
        executorService.shutdown();
    }

    private static class ClientHandler implements Runnable {

        private final LinkedBlockingQueue<ByteBuffer> buffers;
        private SocketChannel clientSocketChannel;
        private ByteBuffer readBuffer = ByteBuffer.allocate(BUFFER_SIZE);
        private ByteBuffer writeBuffer = ByteBuffer.allocate(BUFFER_SIZE);

        public java_38709_SocketServer_A03(LinkedBlockingQueue<ByteBuffer> buffers) {
            this.buffers = buffers;
        }

        @Override
        public void run() {
            try {
                clientSocketChannel = serverSocketChannel.accept();
                clientSocketChannel.configureBlocking(false);

                while ((clientSocketChannel.read(readBuffer)) != -1) {
                    processInput(clientSocketChannel, readBuffer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (clientSocketChannel != null && clientSocketChannel.isConnected()) {
                    try {
                        clientSocketChannel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private void processInput(SocketChannel clientSocketChannel, ByteBuffer readBuffer) {
            // TODO: Implement your processing logic here
            // e.g. use StringBuilder to handle received data, then pass to another thread for further processing
        }
    }
}