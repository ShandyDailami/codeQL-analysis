import java.io.IOException;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.channels.ServerSocketChannel;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class java_06872_SocketServer_A03 {

    public static void main(String[] args) {
        int port = 8000; // default port
        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

        SSLServerSocketChannel sslServerSocketChannel = null;
        try {
            sslServerSocketChannel = SSLServerSocketChannel.open();
            sslServerSocketChannel.bind(port);
            sslServerSocketChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);
            sslServerSocketChannel.setOption(StandardSocketOptions.SO_KEEPALIVE, true);

            SSLServerSocket serverSocket = sslServerSocketChannel.accept();
            serverSocket.setSoLinger(0, 0);

            SSLSocket sslSocket = (SSLSocket) sslServerSocketChannel.accept();
            sslSocket.setSoLinger(0, 0);
            sslSocket.setNeedClientAuth(true);

            runSocket(sslSocket);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sslServerSocketChannel != null) {
                try {
                    sslServerSocketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void runSocket(SSLSocket sslSocket) {
        new Thread(new Runnable() {
            public void run() {
                SocketChannel socketChannel = sslSocket.getSocket().getInputStream();
                Channels.newChannel(socketChannel).管道().forEach(buf -> {
                    buf.flip();
                    ByteBuffer output = buf.duplicate().asReadOnlyBuffer();
                    // do something with the data, e.g., process it
                    output.clear();
                });
            }
        }).start();
    }
}