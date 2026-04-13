import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class java_19141_SocketServer_A01 {
    private static final int PORT = 8189;
    private static final int BUFFER_SIZE = 1024;
    private static final int QUEUE_SIZE = 1024;

    private final Queue<String> messages = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) {
        new BrokenAccessServer().start();
    }

    private void start() {
        try (ServerSocketChannel serverChannel = ServerSocketChannel.open()) {
            serverChannel.bind(new InetSocketAddress(PORT));

            while (true) {
                SocketChannel clientChannel = serverChannel.accept();
                clientChannel.configureBlocking(false);

                Thread thread = new Thread(new ClientHandler(clientChannel));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ClientHandler implements Runnable {
        private final SocketChannel clientChannel;

        private java_19141_SocketServer_A01(SocketChannel clientChannel) {
            this.clientChannel = clientChannel;
        }

        @Override
        public void run() {
            try {
                ByteBuffer readBuffer = ByteBuffer.allocate(BUFFER_SIZE);
                while (clientChannel.read(readBuffer) != -1) {
                    String message = new String(readBuffer.array(), StandardCharsets.UTF_8);
                    if (message.equals("EXIT")) {
                        clientChannel.close();
                        break;
                    } else {
                        // Simulate a security-sensitive operation here.
                        // In this case, we simply echo the message back.
                        ByteBuffer writeBuffer = ByteBuffer.wrap(message.getBytes(StandardCharsets.UTF_8));
                        clientChannel.write(writeBuffer);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}