import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_11086_SocketServer_A08 {
    private static final int PORT = 8080;
    private static final int NTHREADS = 10;

    public static void main(String[] args) throws IOException {
        // create an executor service with NTHREADS threads
        ExecutorService executorService = Executors.newFixedThreadPool(NTHREADS);

        // create a server socket channel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(PORT));

        // set the channel to non-blocking mode
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server is listening on port " + PORT + "...");

        while (true) {
            // accept incoming connections
            SocketChannel socketChannel = serverSocketChannel.accept();

            // if the channel is non-blocking, then we need to handle the event
            if (socketChannel != null) {
                System.out.println("Accepted connection from " + socketChannel.socket().getRemoteSocketAddress());

                // set the channel to non-blocking mode
                socketChannel.configureBlocking(false);

                // create a buffer to hold data
                ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);

                while (socketChannel.read(buffer) != -1) {
                    // flip the buffer for writing
                    buffer.flip();

                    // write data to the client
                    socketChannel.write(buffer);

                    // clear the buffer
                    buffer.clear();
                }

                // close the channel
                socketChannel.close();
            }
        }
    }
}