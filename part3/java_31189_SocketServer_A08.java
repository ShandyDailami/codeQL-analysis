import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketChannel;

public class java_31189_SocketServer_A08 {
    public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException, IOException {
        SSLServerSocketChannel sslChannel = null;
        ServerSocketChannel serverChannel = null;
        try {
            // Create a SSLServerSocket and bind to port 8443
            SSLServerSocket socket = (SSLServerSocket) new SSLServerSocket(8443);
            socket.setNeedClientAuth(true);
            socket.setWantClientAuth(true);

            // Setup SSLChannel
            sslChannel = SSLServerSocketChannel.open(socket);
            sslChannel.bind();

            // Setup ServerSocketChannel
            serverChannel = sslChannel.acceptServerSocketChannel();

            // Create a buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // Read data from the socket
            SocketChannel client = serverChannel.accept();
            while (client.read(buffer) != -1) {
                System.out.println("Received: " + buffer.flip().toString(10));
                client.write(buffer);
                buffer.clear();
            }

            client.close();
        } finally {
            // Close channels
            if (serverChannel != null) serverChannel.close();
            if (sslChannel != null) sslChannel.close();
        }
    }
}