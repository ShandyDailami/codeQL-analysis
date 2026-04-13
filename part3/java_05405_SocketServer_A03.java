import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_05405_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server is listening on port 8080");

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                System.out.println("New client connected!");

                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

                socketChannel.read(readBuffer);
                String request = new String(readBuffer.array(), 0, readBuffer.position());

                // We could do some injection here, but let's not do it for this simple example.

                writeBuffer.put("HTTP/1.1 200 OK\r\n".getBytes());
                writeBuffer.put("Content-Type: text/html\r\n".getBytes());
                writeBuffer.put("\r\n".getBytes());

                socketChannel.write(writeBuffer);
                socketChannel.close();
            }
        }
    }
}