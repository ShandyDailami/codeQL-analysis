import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_33323_SocketServer_A01 {

    private final static int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                System.out.println("Client connected: " + socketChannel.getRemoteAddress());
                executorService.execute(new SocketHandler(socketChannel));
            }
        }
    }
}