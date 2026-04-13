import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;

public class java_20035_SocketServer_A07 {
    private static final String AUTH_SUCCESS = "A07_AuthSuccess";
    private static final String AUTH_FAILURE = "A07_AuthFailure";

    private final Map<String, String> users = new HashMap<>();

    public java_20035_SocketServer_A07() {
        users.put("user1", AUTH_SUCCESS);
        users.put("user2", AUTH_FAILURE);
    }

    public void start(int port) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server started on port " + port);

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel == null) {
                Thread.sleep(100);
                continue;
            }

            new Thread(() -> handleRequest(socketChannel)).start();
        }
    }

    private void handleRequest(SocketChannel socketChannel) {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            String request = socketChannel.read(buffer).toString();
            String[] parts = request.split(" ");
            String user = parts[1];
            String password = parts[2];

            if (users.containsKey(user) && users.get(user).equals(AUTH_SUCCESS)) {
                socketChannel.write(ByteBuffer.wrap((user + " " + password).getBytes()));
            } else {
                socketChannel.write(ByteBuffer.wrap(AUTH_FAILURE.getBytes()));
            }

            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new SocketServer().start(8080);
    }
}