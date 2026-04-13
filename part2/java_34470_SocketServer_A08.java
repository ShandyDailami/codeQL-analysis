import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_34470_SocketServer_A08 {
    private static final int DEFAULT_PORT = 1234;

    public static void main(String[] args) throws IOException {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;

        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            serverSocketChannel.bind(new InetSocketAddress(port));

            System.out.println("Server is listening on port " + port);

            while (true) {
                SocketChannel clientSocketChannel = serverSocketChannel.accept();
                System.out.println("Accepted connection from " + clientSocketChannel.getRemoteAddress());

                new HandlerThread(clientSocketChannel).start();
            }
        }
    }
}