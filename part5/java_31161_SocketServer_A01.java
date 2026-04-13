import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_31161_SocketServer_A01 {
    private final int port;
    private final ExecutorService executor;

    public java_31161_SocketServer_A01(int port) {
        this.port = port;
        this.executor = Executors.newCachedThreadPool();
    }

    public void start() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.listen(5); // listen on port 8080

        System.out.println("Server listening on port " + port);

        while (true) {
            SocketChannel clientSocketChannel = serverSocketChannel.accept();
            if (clientSocketChannel != null) {
                executor.execute(new ClientHandler(clientSocketChannel));
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private final SocketChannel clientSocketChannel;

        public java_31161_SocketServer_A01(SocketChannel clientSocketChannel) {
            this.clientSocketChannel = clientSocketChannel;
        }

        @Override
        public void run() {
            // read from the client and write back to the client
            try {
                while ((clientSocketChannel.read() != -1)) {
                    System.out.println("Received: " + clientSocketChannel.read().toString());
                    clientSocketChannel.write(clientSocketChannel.read());
                }
                clientSocketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new SocketServer(8080).start();
    }
}