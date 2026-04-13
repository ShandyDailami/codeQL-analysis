import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashSet;
import java.util.Set;

public class java_37146_SocketServer_A07 {

    private static final String LOCAL_IP = "127.0.0.1";
    private static final int PORT = 8189;

    private static final Set<String> authorizedClients = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(PORT));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server is running on port " + PORT + ". Waiting for client connections...");

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                processClient(socketChannel);
            }
        }
    }

    private static void processClient(SocketChannel socketChannel) throws IOException {
        String clientIP = socketChannel.socket().getRemoteSocketAddress().toString().substring(1);
        System.out.println("New client connected from " + clientIP);

        if (!authorizedClients.contains(clientIP)) {
            System.out.println("Client " + clientIP + " is not authorized. Closing connection.");
            socketChannel.close();
            return;
        }

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (socketChannel.read(buffer) != -1) {
            buffer.flip();
            System.out.println("Received message: " + new String(buffer.array()));
            buffer.clear();
        }

        socketChannel.close();
    }
}