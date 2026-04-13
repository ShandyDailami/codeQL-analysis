import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_02582_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        SSLServerSocketChannel sslServerSocketChannel = SSLServerSocketChannel.open();
        sslServerSocketChannel.bind(new InetSocketAddress(12345));
        sslServerSocketChannel.setNeedClientAuth(true);

        SSLServerSocket serverSocket = sslServerSocketChannel.acceptSSLServerSocket();
        serverSocket.setNeedClientAuth(true);

        SSLSocket socket = (SSLSocket) serverSocket.accept();
        SocketChannel socketChannel = socket.getSocket();

        socketChannel.configureBlocking(false);

        // Start receiving data
        new Thread(new Runnable() {
            public void run() {
                byte[] bytes = new byte[1024];
                try {
                    int read = socketChannel.read(bytes);
                    while (read != -1) {
                        // Handle incoming data
                        System.out.println(new String(bytes, 0, read));
                        read = socketChannel.read(bytes);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}