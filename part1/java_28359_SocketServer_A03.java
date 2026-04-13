import java.io.IOException;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import javax.net.ssl.SSLServerSocketChannel;
import javax.net.ssl.SSLServerSocketChannel.Accept;
import javax.net.ssl.SSLSocketChannel;

public class java_28359_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        // Create an SSLServerSocketChannel
        SSLServerSocketChannel sslServerChannel = SSLServerSocketChannel.open();
        sslServerChannel.bind(null, 12345);
        sslServerChannel.configureBlocking(false);

        // Accept incoming connections
        SSLSocketChannel sslClientChannel = sslServerChannel.accept();
        sslClientChannel.configureBlocking(false);

        // Bind the socket to the port
        sslClientChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);
        sslClientChannel.bind(null, 12345);

        // Create a buffer to read data from the client
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // Continuously read and echo back data
        while (sslClientChannel.read(buffer) != -1) {
            buffer.flip();
            sslClientChannel.write(buffer);
            buffer.clear();
        }

        sslClientChannel.close();
        sslServerChannel.close();
    }
}