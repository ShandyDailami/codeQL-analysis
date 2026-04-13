import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_17835_SocketServer_A08 {

    private static final int PORT = 8080;
    private static final int NTHREADS = 10;

    public static void main(String[] args) throws IOException {

        // Create an executor service with NTHREADS threads
        ExecutorService executor = Executors.newFixedThreadPool(NTHREADS);

        // Create a ServerSocketChannel and bind it to a port
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(PORT));

        System.out.println("Server is listening on port " + PORT);

        // Continuously accept connections
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                System.out.println("Accepted connection from " + socketChannel.socket().getRemoteSocketAddress());
                executor.submit(new SocketHandler(socketChannel));
            }
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
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

                while (socketChannel.isConnected() && (readBuffer.clear().read(socketChannel) != -1)) {
                    // Process the message read from the socket
                    // Here we just print the message
                    System.out.println("Read message: " + new String(readBuffer.array(), 0, readBuffer.position()));
                    writeBuffer.put(readBuffer.array());

                    // Flip the buffer
                    writeBuffer.flip();

                    // Write the message to the socket
                    while (writeBuffer.hasRemaining()) {
                        socketChannel.write(writeBuffer);
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                socketChannel.close();
            }
        }
    }
}