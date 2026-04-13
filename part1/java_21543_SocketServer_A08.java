import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_21543_SocketServer_A08 {

    private static final int THREADS = Runtime.getRuntime().availableProcessors();

    private final ExecutorService executorService;

    private final AsynchronousServerSocketChannel serverSocketChannel;

    public java_21543_SocketServer_A08(int port) throws IOException {
        executorService = Executors.newFixedThreadPool(THREADS);
        serverSocketChannel = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(port));
        serverSocketChannel.accept(this, new AcceptCompletionHandler());
    }

    public static void main(String[] args) throws IOException {
        new SecureSocketServer(8080);
    }

    private class AcceptCompletionHandler extends CompletionHandler<AsynchronousSocketChannel, SecureSocketServer> {

        @Override
        public AsynchronousSocketChannel create(SocketChannel socketChannel) {
            return AsynchronousSocketChannel.open(socketChannel.socket());
        }

        @Override
        public void completed(AsynchronousSocketChannel socketChannel, SecureSocketServer attachment) {
            socketChannel.accept(attachment, this);
            new ReadHandler(socketChannel, attachment);
        }

        @Override
        public void failed(Throwable exc, SecureSocketServer attachment) {
            // handle exception
        }
    }

    private class ReadHandler extends CompletionHandler<ByteBuffer, SecureSocketServer> {

        private final AsynchronousSocketChannel channel;

        private java_21543_SocketServer_A08(AsynchronousSocketChannel channel, SecureSocketServer server) {
            this.channel = channel;
        }

        @Override
        public void completed(ByteBuffer buffer, SecureSocketServer attachment) {
            // handle read
        }

        @Override
        public void failed(Throwable exc, SecureSocketServer attachment) {
            // handle exception
        }

        @Override
        public void completed(Integer result, ByteBuffer buffer) {
            if (buffer.hasRemaining()) {
                channel.read(buffer, channel, this);
            }
        }
    }
}