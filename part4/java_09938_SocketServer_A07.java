import java.io.IOException;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketChannel;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketChannel;

public class java_09938_SocketServer_A07 {

    private static final Logger logger = Logger.getLogger(SecureSocketServer.class.getName());

    public static void main(String[] args) throws Exception {
        int port = 8080;
        String sslCertificatePath = "path_to_your_ssl_certificate.pem";
        String sslKeyPath = "path_to_your_ssl_key.pem";

        // Setup SSL Server
        SSLServerSocketChannel sslServerSocketChannel = null;
        try {
            SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(port);
            sslServerSocket.setNeedClientAuth(true);
            sslServerSocket.setCertificateExtensions(new String[]{"SSL-Client-Auth"});

            sslServerSocketChannel = SSLServerSocketChannel.open(sslServerSocket);
            sslServerSocketChannel.bind(port);

            sslServerSocketChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);
            sslServerSocketChannel.register(SelectionKey.OP_ACCEPT, SelectionKey.OP_ACCEPT, SSLServerSocketChannel.class);

            logger.log(Level.INFO, "SSL Server started at port {0}", port);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not setup SSL Server", ex);
            return;
        }

        // Setup Accepting Connection
        while (true) {
            SocketChannel socketChannel = sslServerSocketChannel.accept();
            socketChannel.configureBlocking(false);
            socketChannel.setOption(StandardSocketOptions.SO_KEEPALIVE, true);

            SSLSocketChannel sslSocketChannel = sslServerSocketChannel.acceptChannel();
            SSLSocket sslSocket = sslSocketChannel.accept();

            sslSocket.setNeedClientAuth(true);
            sslSocket.setReadBufferSize(1 << 12);
            sslSocket.setPerformancePreferences(sslSocket.getDefaultPerformancePreferences(), true);

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (sslSocket.getInputStream().read(buffer) != -1) {
                buffer.flip();
                // Process the received message
                logger.log(Level.INFO, "Received: {0}", new String(buffer.array()));
                buffer.clear();
            }

            sslSocketChannel.close();
        }
    }
}