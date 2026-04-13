import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_27061_SocketServer_A07 {
    private final static int PORT = 8189;
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        new AuthServer().start();
    }

    private void start() {
        ServerSocketChannel serverSocketChannel;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(PORT));
            serverSocketChannel.configureBlocking(false);

            System.out.println("Server started. Listening on port: " + PORT);

            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel != null) {
                    executor.execute(new SocketHandler(socketChannel));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    private class SocketHandler implements Runnable {
        private final SocketChannel socketChannel;

        public java_27061_SocketServer_A07(SocketChannel socketChannel) {
            this.socketChannel = socketChannel;
        }

        @Override
        public void run() {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            try {
                while (socketChannel.read(buffer) != -1) {
                    buffer.flip();
                    String request = new String(buffer.array(), "UTF-8");
                    if (validate(request)) {
                        sendResponse(socketChannel, "Success!");
                    } else {
                        sendResponse(socketChannel, "Authentication failed!");
                    }
                    buffer.clear();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void sendResponse(SocketChannel socketChannel, String response) throws IOException {
            socketChannel.write(ByteBuffer.wrap(response.getBytes()));
        }

        private boolean validate(String request) {
            // Here you can implement your own authentication logic
            // This is just a simple example. In a real application, you should use a more secure method to compare the request with a stored hash.
            return request.equals("expected_request");
        }
    }
}