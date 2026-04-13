import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.message.callback.PasswordCallback;

public class java_34615_SocketServer_A07 {

    private static Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public static void main(String[] args) throws IOException {
        runServer(8080);
    }

    private static void runServer(int port) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server started on port " + port);

        while (true) {
            SocketChannel clientSocketChannel = serverSocketChannel.accept();
            if (clientSocketChannel != null) {
                System.out.println("Accepted connection from " + clientSocketChannel);
                new Handler(clientSocketChannel).start();
            }
        }
    }

    private static class Handler extends Thread {
        private final SocketChannel socketChannel;

        Handler(SocketChannel socketChannel) {
            this.socketChannel = socketChannel;
        }

        @Override
        public void run() {
            try {
                // Read the initial request
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                socketChannel.read(buffer);

                // Decode the request
                String request = new String(buffer.array(), "UTF-8");
                System.out.println("Received: " + request);

                // Basic Authentication
                String[] credentials = request.split(" ");
                if (authenticate(credentials[0], credentials[1])) {
                    socketChannel.write(ByteBuffer.wrap("HTTP/1.1 200 OK\r\n\r\n".getBytes()));
                } else {
                    socketChannel.write(ByteBuffer.wrap("HTTP/1.1 401 Unauthorized\r\n\r\n".getBytes()));
                }

                socketChannel.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        private boolean authenticate(String username, String password) {
            return credentials.get(username).equals(password);
        }
    }
}