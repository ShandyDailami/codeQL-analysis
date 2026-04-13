import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketChannel;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketChannel;

public class java_23119_SocketServer_A07 {
    private final int port;

    public java_23119_SocketServer_A07(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        SSLServerSocketChannel sslServerSocketChannel = null;
        ServerSocketChannel serverSocketChannel = null;

        try {
            // Create a SSL server socket
            SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(port);
            sslServerSocket.setNeedClientAuth(true);

            sslServerSocketChannel = (SSLServerSocketChannel) sslServerSocket.accept();
            sslServerSocketChannel.configureBlocking(false);

            serverSocketChannel = serverSocketChannel(sslServerSocketChannel);
            serverSocketChannel.bind(new InetSocketAddress(port));
            serverSocketChannel.configureBlocking(false);

            System.out.println("Listening for connections on port " + port);

            while (true) {
                SocketChannel clientChannel = serverSocketChannel.accept();
                if (clientChannel != null) {
                    System.out.println("Accepted client connection from " + clientChannel);

                    // Setup SSL connection
                    SSLSocketChannel sslChannel = (SSLSocketChannel) clientChannel.accept();
                    sslChannel.configureBlocking(false);

                    // Perform SSL handshake
                    SSLSocket socket = sslChannel.accept();

                    // Authenticate the client using our custom AuthenticationHandler
                    AuthenticationHandler authenticationHandler = new AuthenticationHandler();
                    if (authenticationHandler.authenticate(socket)) {
                        System.out.println("Client authenticated successfully!");
                        // Handle connection here
                    } else {
                        System.out.println("Client authentication failed!");
                        // Close connection here
                    }
                }
            }
        } finally {
            if (sslServerSocketChannel != null) sslServerSocketChannel.close();
            if (serverSocketChannel != null) serverSocketChannel.close();
        }
    }

    private ServerSocketChannel serverSocketChannel(SSLServerSocketChannel sslServerSocketChannel) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);
        return serverSocketChannel;
    }

    public static void main(String[] args) throws IOException {
        new SecureSocketServer(8080).start();
    }
}