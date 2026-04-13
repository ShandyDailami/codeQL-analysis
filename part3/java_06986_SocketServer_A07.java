import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;

public class java_06986_SocketServer_A07 {

    private static Map<String, String> userMap = new HashMap<>(); // Dummy user map

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server is listening on port 8080");

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                System.out.println("A new connection is accepted from: " + socketChannel.socket().getRemoteSocketAddress());

                socketChannel.configureBlocking(false);

                SelectionKey selectionKey = socketChannel.keyForAccept();
                selectionKey.interestOps(SelectionKey.OP_ACCEPT);
                selectionKey.attach(new Acceptor(socketChannel));
            }
        }
    }

    static class Acceptor implements Runnable {
        private SocketChannel socketChannel;

        Acceptor(SocketChannel socketChannel) {
            this.socketChannel = socketChannel;
        }

        @Override
        public void run() {
            try {
                // Read the client's message
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                socketChannel.read(buffer);

                // Process the client's message
                String request = new String(buffer.array(), 0, buffer.position());
                System.out.println("Received: " + request);

                // Assume the client is trying to authenticate with a username and password
                String[] credentials = request.split(" ");
                String username = credentials[0];
                String password = credentials[1];

                // Perform authentication (this is a mockup, so it always succeeds)
                if (authenticate(username, password)) {
                    System.out.println("Authentication succeeded");
                    socketChannel.write(ByteBuffer.wrap("Authentication succeeded".getBytes()));
                } else {
                    System.out.println("Authentication failed");
                    socketChannel.write(ByteBuffer.wrap("Authentication failed".getBytes()));
                }

                socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean authenticate(String username, String password) {
            // This is a simple mockup authentication. In a real-world scenario, you would need
            // to query the database or other security system to verify the username and password.
            return username.equals("user") && password.equals("password");
        }
    }
}