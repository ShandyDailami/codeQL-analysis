import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_25145_SocketServer_A03 {

    private final static int PORT = 9999;

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(PORT));

        System.out.println("Server is listening on port " + PORT);

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            executorService.execute(new SocketHandler(socketChannel));
        }
    }

    static class SocketHandler implements Runnable {
        private final SocketChannel socketChannel;

        SocketHandler(SocketChannel socketChannel) {
            this.socketChannel = socketChannel;
        }

        @Override
        public void run() {
            try {
                ByteBuffer buffer = ByteBuffer.allocate(1024);

                while (socketChannel.read(buffer) != -1) {
                    buffer.flip();

                    // TODO: Implement security-sensitive operations

                    buffer.flip();
                    socketChannel.write(buffer);
                    buffer.clear();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}