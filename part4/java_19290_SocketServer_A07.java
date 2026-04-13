import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;

public class java_19290_SocketServer_A07 {
    private Map<String, String> users = new HashMap<>();

    public java_19290_SocketServer_A07() {
        users.put("user", "user");
    }

    public void start(int port) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(serverSocketChannel.socket().getLocalSocketAddress());
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server started on port " + port);

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                System.out.println("New client connected");
                SelectionKey key = socketChannel.keys().iterator().next();
                if (key.isValid()) {
                    handle(socketChannel);
                }
            }
        }
    }

    private void handle(SocketChannel socketChannel) throws IOException {
        if (!socketChannel.isConnected()) {
            return;
        }

        SelectionKey key = socketChannel.keys().iterator().next();
        if (key.isValid()) {
            if (key.isConnectable()) {
                SocketChannel connectedChannel = socketChannel.socket().accept();
                connectedChannel.configureBlocking(false);
                key = connectedChannel.keys().iterator().next();
            }

            if (key.isReadable()) {
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                int bytesRead = socketChannel.read(buffer);
                if (bytesRead == -1) {
                    socketChannel.close();
                    System.out.println("Client disconnected");
                } else {
                    String request = new String(buffer.array(), 0, bytesRead);
                    System.out.println("Received: " + request);

                    if ("auth user".equals(request)) {
                        authenticate(socketChannel, connectedChannel);
                    } else {
                        handleRequest(socketChannel, connectedChannel, request);
                    }
                }
            }
        }
    }

    private void authenticate(SocketChannel channel, SocketChannel connectedChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        connectedChannel.write(buffer.put("OK".getBytes()));
    }

    private void handleRequest(SocketChannel channel, SocketChannel connectedChannel, String request) throws IOException {
        // handle request here, for example
        String response = "Hello " + request;
        connectedChannel.write(response.getBytes());
    }

    public static void main(String[] args) throws IOException {
        new SocketServer().start(8181);
    }
}