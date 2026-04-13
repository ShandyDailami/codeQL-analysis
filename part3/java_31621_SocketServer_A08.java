import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_31621_SocketServer_A08 {

    public static void main(String[] args) {
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            InetSocketAddress address = new InetSocketAddress("localhost", 8080);
            serverSocketChannel.bind(address);

            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                System.out.println("New client connected!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}