import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketChannel;

public class java_19823_SocketServer_A01 {
    private static final int PORT = 8080;
    private static final SSLContext sslContext = SSLContext.getInstance("TLS");

    public static void main(String[] args) throws Exception {
        // Load the SSL certificate and key
        sslContext.init(null, new String[]{"server.key"}, null);

        ServerSocketChannel serverSocketChannel = null;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(PORT));
            serverSocketChannel.configureBlocking(false);

            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("Server is listening on port " + PORT);

            while (true) {
                selector.select();
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();

                    if (key.isAcceptable()) {
                        ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) key.channel();
                        SocketChannel socketChannel = serverSocketChannel1.accept();
                        socketChannel.configureBlocking(false);

                        SSLEngine sslEngine = sslContext.createSSLEngine();
                        sslEngine.setRemoteCertificate(serverSocketChannel1.getRemoteCertificate());
                        socketChannel.register(selector, SelectionKey.OP_READ, sslEngine);

                        System.out.println("Client " + socketChannel.getRemoteAddress() + " connected");
                    } else if (key.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        SSLEngine sslEngine = (SSLEngine) key.attachment();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        int bytesRead = socketChannel.read(buffer);

                        while (bytesRead != -1) {
                            sslEngine.getInputStream().mark(bytesRead);
                            sslEngine.update();
                            buffer.flip();

                            while (buffer.hasRemaining()) {
                                sslEngine.getOutputStream().write(buffer.get());
                            }

                            sslEngine.outputFlush();
                            buffer.clear();

                            bytesRead = socketChannel.read(buffer);
                        }

                        sslEngine.close();
                        socketChannel.close();

                        System.out.println("Client " + socketChannel.getRemoteAddress() + " disconnected");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocketChannel != null) {
                serverSocketChannel.close();
            }
        }
    }
}