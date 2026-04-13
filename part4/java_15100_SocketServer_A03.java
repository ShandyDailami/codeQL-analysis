import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class java_15100_SocketServer_A03 {

    private final Queue<String> messageQueue = new ConcurrentLinkedQueue<>();
    private final ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private final ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
    private SocketChannel channel;

    public void start(int port) {
        try {
            channel = SocketChannel.open();
            channel.bind(new InetSocketAddress(port));
            channel.configureBlocking(false);
            System.out.println("Server is listening on port " + port);

            new Thread(() -> {
                while (true) {
                    try {
                        SocketChannel clientChannel = channel.accept();
                        clientChannel.configureBlocking(false);
                        new Handler(clientChannel).start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class Handler extends Thread {
        private final SocketChannel clientChannel;

        public java_15100_SocketServer_A03(SocketChannel clientChannel) {
            this.clientChannel = clientChannel;
        }

        @Override
        public void run() {
            try {
                while ((clientChannel.read(readBuffer)) != -1) {
                    String message = new String(readBuffer.array(), StandardCharsets.UTF_8);
                    System.out.println("Received: " + message);
                    messageQueue.offer(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new SecureSocketServer().start(8080);
    }
}