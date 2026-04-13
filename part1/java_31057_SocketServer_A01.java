import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashSet;
import java.util.Set;

public class java_31057_SocketServer_A01 {
    private static final String LOCAL_IP = "192.168.1.0";
    private static final Set<String> ALLOWED_IPS = new HashSet<>();
    private static final String ALLOWED_IP_PREFIX = "192.168.1.";
    private static final int ALLOWED_IPS_COUNT = 256;
    private static final int PORT = 8080;

    static {
        ALLOWED_IPS.add(ALLOWED_IP_PREFIX + "0");
        for (int i = 1; i <= ALLOWED_IPS_COUNT; i++) {
            ALLOWED_IPS.add(ALLOWED_IP_PREFIX + i);
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(PORT));
        serverSocketChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);

        System.out.println("Server is listening on port " + PORT + "...");

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (isClientAllowed(socketChannel.getRemoteAddress())) {
                System.out.println("Client " + socketChannel.getRemoteAddress() + " is allowed to connect.");
                // Handle the connection...
            } else {
                System.out.println("Client " + socketChannel.getRemoteAddress() + " is not allowed to connect.");
                socketChannel.close();
            }
        }
    }

    private static boolean isClientAllowed(SocketAddress remoteAddress) {
        String clientIp = remoteAddress.toString().split(":")[0];
        return ALLOWED_IPS.contains(clientIp);
    }
}