import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Channel;
import java.util.Iterator;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_08356_SocketServer_A03 {

    private final ServerSocketChannel serverSocketChannel;
    private SSLServerSocket sslServerSocket;
    private volatile boolean running = true;

    public java_08356_SocketServer_A03(int port) {
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(port));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().setReuseAddress(true);

            sslServerSocket = (SSLServerSocket) serverSocketChannel.socket();
            sslServerSocket.setNeedClientAuth(true);

            System.setProperty("javax.net.ssl.keyStore", "server.jks");
            System.setProperty("javax.net.ssl.keyStorePassword", "password");
            System.setProperty("javax.net.ssl.trustStore", "client.jks");
            System.setProperty("javax.net.ssl.trustStorePassword", "password");
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public void start() {
        new Thread(this::acceptConnections).start();
    }

    private void acceptConnections() {
        while (running) {
            try {
                SelectionKey key = serverSocketChannel.select().accept();
                if (key != null) {
                    Channel ch = key.channel();
                    if (ch != null) {
                        handleAccept(ch);
                    }
                }
            } catch (Exception e) {
                running = false;
            }
        }
    }

    private void handleAccept(Channel ch) throws Exception {
        // handle accepting connections
    }

    public void stop() {
        running = false;
        serverSocketChannel.close();
        sslServerSocket.close();
    }

    public static void main(String[] args) {
        SocketServer server = new SocketServer(8080);
        server.start();
    }
}