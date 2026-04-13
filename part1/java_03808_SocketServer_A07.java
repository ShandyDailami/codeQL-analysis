import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_03808_SocketServer_A07 {

    private static final int PORT = 8080;
    private static final String HOST = "localhost";
    private static final int THREADS = 5;

    public static void main(String[] args) throws Exception {
        // Create a thread pool with a specified number of threads
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);

        // Create a server socket channel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // Bind the socket to a port and wait for incoming connections
        serverSocketChannel.bind(new InetSocketAddress(PORT));

        System.out.println("Server is listening on port " + PORT);

        // Accept incoming connections
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            System.out.println("Client connected from " + socketChannel.getRemoteAddress());

            // Split the socket channel into two for reading and writing
            SocketChannel readChannel = socketChannel.socket().accept();
            SocketChannel writeChannel = socketChannel.socket().accept();

            // Use executor service to handle the read and write channels
            executorService.execute(new ClientHandler(readChannel, writeChannel));
        }
    }

    static class ClientHandler implements Runnable {
        private SocketChannel readChannel;
        private SocketChannel writeChannel;

        public java_03808_SocketServer_A07(SocketChannel readChannel, SocketChannel writeChannel) {
            this.readChannel = readChannel;
            this.writeChannel = writeChannel;
        }

        @Override
        public void run() {
            // Handle the read and write channels
            // For example, we read data from the read channel and write it back to the write channel
            try {
                byte[] bytes = new byte[1024];
                while (readChannel.read(BytesBuffer) > 0) {
                    writeChannel.write(bytes);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}