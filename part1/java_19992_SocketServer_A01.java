import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_19992_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        // Create a ServerSocketChannel and bind it to a port
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));

        // Start an infinite loop to accept connections
        while (true) {
            // Accept a client connection
            SocketChannel clientSocketChannel = serverSocketChannel.accept();

            // If a client connection is accepted, handle it
            if (clientSocketChannel != null) {
                // Handle the client connection here using a separate thread
                new Thread(new SocketHandler(clientSocketChannel)).start();
            }
        }
    }

    private static class SocketHandler implements Runnable {

        private SocketChannel clientSocketChannel;

        public java_19992_SocketServer_A01(SocketChannel clientSocketChannel) {
            this.clientSocketChannel = clientSocketChannel;
        }

        @Override
        public void run() {
            // Handle the client connection here
            // For now, we just close the socket channel
            try {
                clientSocketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}