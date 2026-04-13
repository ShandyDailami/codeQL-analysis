import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;

public class java_38745_SocketServer_A03 {
    private static final String PASSWORD = "password";
    private Map<String, String> clients = new HashMap<>();

    public void start(int port) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);
        System.out.println("Server started on port: " + port);

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                handleClient(socketChannel);
            }
        }
    }

    private void handleClient(SocketChannel socketChannel) throws IOException {
        String clientAddress = socketChannel.socket().getRemoteSocketAddress().toString();

        byte[] bytes = new byte[1024];
        socketChannel.read(ByteBuffer.wrap(bytes));
        String password = new String(bytes);

        if (PASSWORD.equals(password)) {
            clients.put(clientAddress, PASSWORD);
            socketChannel.close();
        } else {
            System.out.println("Access denied by " + clientAddress);
        }
    }

    public static void main(String[] args) throws IOException {
        new SecureSocketServer().start(8080);
    }
}