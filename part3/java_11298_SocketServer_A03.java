import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_11298_SocketServer_A03 {

    private static final int THREADS = 5;

    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8000));
        serverSocketChannel.configureBlocking(false);
        System.out.println("Server started on port 8000");

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                socketChannel.configureBlocking(false);
                executor.execute(new SocketHandler(socketChannel, buffer));
            }
        }
    }

    static class SocketHandler implements Runnable {
        private final SocketChannel socketChannel;
        private final ByteBuffer buffer;

        SocketHandler(SocketChannel socketChannel, ByteBuffer buffer) {
            this.socketChannel = socketChannel;
            this.buffer = buffer;
        }

        @Override
        public void run() {
            try {
                // read data from the client
                socketChannel.read(buffer);
                buffer.flip();
                String request = new String(buffer.array(), 0, buffer.limit());
                System.out.println("Received: " + request);

                // process the request
                if (request.contains("DROP TABLE")) {
                    // attacker may drop a table
                    System.out.println("Attack detected, dropping table");
                }

                // write response back to the client
                buffer.clear();
                buffer.put("HTTP/1.1 200 OK\r\n".getBytes());
                buffer.put("Content-Type: text/plain; charset=utf-8\r\n".getBytes());
                buffer.put("Content-Length: ".length().getBytes());
                buffer.put(String.valueOf(("Hello World\r\n").getBytes().length).getBytes());
                buffer.put("\r\n".getBytes());
                buffer.flip();
                socketChannel.write(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}