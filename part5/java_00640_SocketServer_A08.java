import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class java_00640_SocketServer_A08 {

    private static SSLServerSocketChannel sslServerChannel;
    private static SSLSocket sslSocket;
    private static ServerSocketChannel serverChannel;
    private static SocketChannel clientChannel;

    public static void main(String[] args) {
        int port = 8080;
        boolean secureServer = false; // Set to true if you want to use SSL

        try {
            // Set up SSL if required
            if (secureServer) {
                SSLServerSocketChannel sslServerChannel = (SSLServerSocketChannel) serverChannel.accept();
                sslSocket = sslServerChannel.accept();
                sslSocket.setNeedClientAuth(true);
                SSLSocketFactory sslSocketFactory = sslSocket.getSocket().getSocketFactory();

                // Set up SSL connection
                sslSocket.setNeedClientAuth(true);
                sslSocket.setEnabledProtocols(new String[] { "TLSv1.2" });
                sslSocket.setEnabledCipherSuites(new String[] { "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "SSLv3" });
                sslSocket.startHandshake();
                System.out.println("Handshake completed");
            }

            // Bind to port and listen for client connections
            InetSocketAddress addr = new InetSocketAddress(port);
            serverChannel = ServerSocketChannel.open();
            serverChannel.socket().bind(addr);
            serverChannel.configureBlocking(false);

            // Accept client connections
            while (true) {
                SocketChannel clientChannel = serverChannel.accept();
                if (clientChannel != null) {
                    System.out.println("Accepted connection from " + clientChannel.getRemoteAddress().toString());
                    clientChannel.configureBlocking(false);

                    // Perform security-sensitive operations here

                    // Close connection
                    clientChannel.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}