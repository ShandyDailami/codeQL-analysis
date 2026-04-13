import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_38753_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server is listening on port 8080");

        while (true) {
            SocketChannel clientSocketChannel = serverSocketChannel.accept();
            if (clientSocketChannel != null) {
                System.out.println("Client connected");
                clientSocketChannel.configureBlocking(false);

                // Perform handshake to authenticate the client
                // This is a very basic example and may not be secure
                clientSocketChannel.write(ByteBuffer.wrap("Hello Client\n".getBytes()));
                byte[] buffer = new byte[1024];
                int bytesRead = clientSocketChannel.read(ByteBuffer.wrap(buffer));

                if (bytesRead < 0) {
                    System.out.println("Client disconnected");
                    clientSocketChannel.close();
               .
                .
                .
                // More code...
            }
        }
    }
}