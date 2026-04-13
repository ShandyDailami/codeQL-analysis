import java.io.IOException;
import java.net.InetSocketAddr;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketChannel;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketChannel;

public class java_13091_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        int port = 8888;
        SSLServerSocketChannel sslServerSocketChannel = null;
        ServerSocketChannel serverSocketChannel = null;
        SSLServerSocket serverSocket = null;
        SocketChannel clientSocket = null;

        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(port);
            serverSocket.setNeedClientAuth(true);
            serverSocket.setWantClientAuth(true);

            sslServerSocketChannel = (SSLServerSocketChannel) serverSocket.accept();
            sslServerSocketChannel.configureBlocking(false);

            clientSocket = sslServerSocketChannel.accept();
            clientSocket.configureBlocking(false);

            // Here is where we handle the SSL handshake
            SSLSocket sslSocket = (SSLSocket) sslServerSocketChannel.accept();
            sslSocket.setNeedClientAuth(true);
            sslSocket.setWantClientAuth(true);

            // Here is where we handle the authentication
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int bytesRead = sslSocket.getInputStream().read(buffer);
            while (bytesRead != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }
                buffer.clear();
                bytesRead = sslSocket.getInputStream().read(buffer);
            }

            System.out.println("Successfully authenticated!");
        } finally {
            if (clientSocket != null) clientSocket.close();
            if (sslServerSocketChannel != null) sslServerSocketChannel.close();
            if (serverSocket != null) serverSocket.close();
        }
    }
}