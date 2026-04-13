import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_38442_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        SSLSocket sslSocket = (SSLSocket) serverSocketChannel.accept();
        sslSocket.setNeedClientAuth(true);
        sslSocket.startHandshake();

        if (sslSocket.getState().equals(SSLSocket.CLOSED)) {
            throw new IOException("Connection closed");
        }

        SocketChannel clientChannel = sslSocket.getInputStream();
        // rest of your code...
    }
}