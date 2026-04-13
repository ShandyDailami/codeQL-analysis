import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_32399_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server is listening on port 8080");

        while (true) {
            SocketChannel clientSocketChannel = serverSocketChannel.accept();
            if (clientSocketChannel != null) {
                System.out.println("A client connected");

                // Handle client connection in a separate thread
                new Thread(new ClientHandler(clientSocketChannel)).start();
            }
        }
    }

    static class ClientHandler implements Runnable {
        private SocketChannel clientSocketChannel;

        public java_32399_SocketServer_A08(SocketChannel clientSocketChannel) {
            this.clientSocketChannel = clientSocketChannel;
        }

        @Override
        public void run() {
            // Handle client communication here
        }
    }
}