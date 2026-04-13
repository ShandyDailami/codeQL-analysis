import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.security.KeyStore;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_35281_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        int port = 8080;

        // For SSL
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(ClassLoader.getSystemResourceAsStream("truststore.jks"), "truststorepassword".toCharArray());
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory.setKeyStore(keyStore);
        sslServerSocketFactory.setKeyStorePassword("keystorepassword");

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);

        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
        sslServerSocket.setNeedClientAuth(true);

        while (true) {
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.startHandshake();

            SocketChannel socketChannel = sslSocket.getRemoteSocket().getChannel();
            socketChannel.configureBlocking(false);

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (socketChannel.read(buffer) != -1) {
                buffer.flip();
                System.out.println(new String(buffer.array(), "UTF-8"));
                buffer.clear();
            }

            sslSocket.close();
        }
    }
}