import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketChannel;
import javax.net.ssl.SSLSocketChannel;

public class java_37983_SocketServer_A03 {
    private static final String SSL_PORT = "9001";
    private static final String NON_SSL_PORT = "9000";

    public static void main(String[] args) throws IOException, CertificateException {
        runServer(SSL_PORT);
        //runServer(NON_SSL_PORT);
    }

    private static void runServer(String port) throws IOException, CertificateException {
        ServerSocketChannel ssc = null;
        try {
            ssc = ServerSocketChannel.open();
            ssc.bind(new InetSocketAddress(Integer.parseInt(port)));
            ssc.configureBlocking(false);

            SSLServerSocketChannel ssssc = ssc.asServerSocketChannel();
            ssssc.configureBlocking(false);

            SSLServerSocket sslServerSocket = (SSLServerSocket) ssssc.socket();
            sslServerSocket.setNeedClient(true);
            sslServerSocket.setPort(Integer.parseInt(port));

            System.out.println("Server SSL port: " + port);

            while (true) {
                SelectionKey key = ssc.select().nextKey();
                if (key != null) {
                    if (key.isValid()) {
                        SocketChannel sc = ssc.accept();
                        if (sc != null) {
                            sc.configureBlocking(false);

                            SSLSocketChannel sslSc = sc.asSocketChannel();
                            sslSc.configureBlocking(false);

                            sslSc.bind(new java.net.InetSocketAddress(Integer.parseInt(port)));
                            sslSc.setNeedClient(true);
                            sslSc.setPort(Integer.parseInt(port));

                            System.out.println("Client SSL port: " + port);

                            new Handler(sslSc).start();
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends Thread {
        private SocketChannel sc;

        public java_37983_SocketServer_A03(SocketChannel sc) {
            this.sc = sc;
        }

        public void run() {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            String result = "";
            while (sc.read(buffer) != -1) {
                buffer.flip();
                result += new String(buffer.array(), StandardCharsets.UTF_8);
                buffer.clear();
            }

            System.out.println("Received: " + result);
            sc.close();
        }
    }
}