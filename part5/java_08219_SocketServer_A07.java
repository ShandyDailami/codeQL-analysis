import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Optional;
import java.util.function.Supplier;

import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketChannel;

public class java_08219_SocketServer_A07 {
    private static final SSLContext sslContext = SSLContext.getInstance("TLS");
    private static final Supplier<ByteBuffer> bufferSupplier = () -> ByteBuffer.allocate(1024);

    static {
        try {
            sslContext.init(null, new String[]{"SSL_SERVER_KEY.pem", "SSL_SERVER_CERT.pem"}, null);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        runServer(8443);
    }

    private static void runServer(int port) throws IOException {
        SSLServerSocketChannel serverChannel = sslContext.wrapServerSocketChannel(createServerSocket(port));
        while (true) {
            Optional<SocketChannel> clientChannel = getClient(serverChannel);
            if (clientChannel.isPresent()) {
                processClient(clientChannel.get());
            }
        }
    }

    private static void processClient(SocketChannel clientChannel) throws IOException {
        SSLEngine sslEngine = sslContext.createSSLEngine();
        clientChannel.pipe(sslEngine);
        sslEngine.startHandshake();
        sslEngine.finish();
        // Here you can write your code
    }

    private static SSLServerSocketChannel createServerSocket(int port) {
        try {
            SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(port);
            serverSocket.setNeedClient(true);
            return serverSocket.createChannel();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private static Optional<SocketChannel> getClient(SSLServerSocketChannel serverChannel) throws IOException {
        InetSocketAddress remoteAddress = (InetSocketAddress) serverChannel.getLocalAddress();
        SocketChannel clientChannel = serverChannel.accept();
        clientChannel.configureBlocking(false);
        if (clientChannel.connect(remoteAddress)) {
            return Optional.of(clientChannel);
        } else {
            return Optional.empty();
        }
    }
}