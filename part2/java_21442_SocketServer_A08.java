import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_21442_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        while (true) {
            SocketChannel clientSocketChannel = serverSocketChannel.accept();
            if (clientSocketChannel != null) {
                // Process the client connection
                clientSocketChannel.configureBlocking(false);
                byte[] bytes = new byte[1024];
                int bytesRead = clientSocketChannel.read(bytes);
                if (bytesRead == -1) {
                    clientSocketChannel.close();
                } else {
                    // Here, we assume that the client is sending a clear text message for security purpose.
                    // In real scenario, the server should handle this using SSL/TLS for secure communication.
                    System.out.println(new String(bytes, 0, bytesRead));
                    clientSocketChannel.write(bytes);
               
                }
            }
        }
    }
}