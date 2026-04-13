import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import javax.net.ssl.*;

public class java_01968_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        SSLServerSocketChannel sslServerChannel = null;
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);
        
        // Create a SSLServerSocketChannel
        sslServerChannel = SSLServerSocketChannel.open(serverSocketChannel);
        sslServerChannel.bind(new InetSocketAddress(8080));
        sslServerChannel.configureBlocking(false);
        
        while (true) {
            SocketChannel clientChannel = sslServerChannel.accept();
            if (clientChannel != null) {
                System.out.println("Accepted client connection from: " + clientChannel.socket().getRemoteSocketAddress());
                // Send a hello message to the client
                clientChannel.write(StandardCharsets.US_ASCII.encode("Hello from server!"));
            }
        }
    }
}