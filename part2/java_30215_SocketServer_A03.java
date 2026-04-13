import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_30215_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        // Create a SSL Server Socket
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

        // Set the socket to accept incoming connections
        ServerSocketChannel serverSocketChannel = sslServerSocket.acceptSocketChannel();

        // Set the socket to non-blocking mode
        serverSocketChannel.configureBlocking(false);

        // Accept and handle incoming connections
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            // socketChannel.configureBlocking(false);

            // Perform socket authentication
            if (socketChannel.isConnectionSet()) {
                socketChannel.write(socketChannel.getLocalAddress().toString().getBytes());
                socketChannel.close();
            }
        }
    }
}