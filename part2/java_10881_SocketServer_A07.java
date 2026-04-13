import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.ServerSocketChannel;
import javax.net.ssl.SSLServerSocketChannel;

public class java_10881_SocketServer_A07 {
    private static final String SSL_PROTOCOL = "TLS";
    private static final String KEYSTORE_TYPE = "JKS";
    private static final String KEYSTORE_LOCATION = "keystore.jks";
    private static final char[] KEYSTORE_PASSWORD = "password".toCharArray();
    private static final String ALGORITHM = "SunEC";

    private static class SocketServerHandler implements Runnable {
        private Selector selector;

        public java_10881_SocketServer_A07(Selector selector) {
            this.selector = selector;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    selector.select();
                    for (SelectionKey key : selector.selectedKeys()) {
                        if (key.isAcceptable()) {
                            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                            SocketChannel sc = ssc.accept();
                            sc.configureBlocking(false);
                            SelectionKey sk = sc.keyFor();
                            selector.selectedKeys().remove(sk);
                            sk.attach(new SocketServerHandler(selector));
                        } else if (key.isReadable()) {
                            // handle read event
                        } else if (key.isWritable()) {
                            // handle write event
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException, CertificateException, KeyStoreException {
        ServerSocketChannel ssc = null;

        try {
            ssc = (ServerSocketChannel) SSLServerSocketChannel.open();
            ssc.bind(new InetSocketAddress(8080));
            ssc.configureBlocking(false);

            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyStore.getDefaultType());
            kmf.init(KeyStore.getDefaultType(), null);

            ssc.setOption(ChannelOption.SO_SSL_SERVER_BIND_HOST_NAME, "localhost");
            ssc.bind(new InetSocketAddress("localhost", 8080));
            ssc.configureBlocking(false);
            ssc.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                selector.select();
                for (SelectionKey key : selector.selectedKeys()) {
                    if (key.isAcceptable()) {
                        ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                        SocketChannel sc = ssc.accept();
                        sc.configureBlocking(false);
                        SelectionKey sk = sc.keyFor();
                        selector.selectedKeys().remove(sk);
                        sk.attach(new SocketServerHandler(selector));
                    } else if (key.isReadable()) {
                        // handle read event
                    } else if (key.isWritable()) {
                        // handle write event
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}