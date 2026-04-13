import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashSet;
import java.util.Set;

public class java_05560_SocketServer_A03 {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8189;
    private static final int TIMEOUT = 60000;

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(SERVER_HOST, SERVER_PORT));
        serverChannel.configureBlocking(false);
        Set<SocketChannel> socketChannels = new HashSet<>();

        System.out.println("Server started, waiting for connections on port " + SERVER_PORT);

        while (true) {
            SocketChannel socketChannel = serverChannel.accept();
            if (socketChannel != null) {
                socketChannels.add(socketChannel);
            }

            for (SocketChannel channel : socketChannels) {
                if (!channel.isOpen()) {
                    continue;
                }

                ByteBuffer buffer = ByteBuffer.allocate(1024);
                if (channel.read(buffer) == -1) {
                    System.out.println("Connection closed by client on channel " + channel);
                    channel.close();
                    socketChannels.remove(channel);
                } else {
                    String request = new String(buffer.array(), 0, buffer.position());
                    // Here you can safely and cleanly do whatever you need to with the request
                    System.out.println("Received: " + request);
                }
            }

            try {
                Thread.sleep(TIMEOUT);
            } catch (InterruptedException e) {
                Thread.interrupted();
                System.exit(0);
            }
        }
    }
}