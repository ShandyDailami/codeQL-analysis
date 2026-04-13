import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_19160_SocketServer_A07 {
    private static final int DEFAULT_PORT = 8080;
    private static SSLServerSocket sslServerSocket;
    private static SSLEngine sslEngine;

    private SSLContext sslContext;

    private java_19160_SocketServer_A07() throws NoSuchAlgorithmException, KeyStoreException, CertificateException, UnrecoverableKeyException, IOException {
        sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new String[]{"TLSv1.2"}, null);

        sslServerSocket = (SSLServerSocket) sslContext.getServerSocket(DEFAULT_PORT);
        sslServerSocket.setNeedClientAuth(true);

        sslEngine = sslContext.createSSLEngine(sslServerSocket.accept());
        sslEngine.handshake();
    }

    public static void main(String[] args) {
        try {
            new SocketServer();

            while (true) {
                SocketChannel clientChannel = sslEngine.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(1024);

                while (clientChannel.read(buffer) != -1) {
                    buffer.flip();

                    // Process the received message here
                    byte[] receivedBytes = new byte[buffer.remaining()];
                    buffer.get(receivedBytes);
                    System.out.println(new String(receivedBytes, StandardCharsets.UTF_8));

                    buffer.clear();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}