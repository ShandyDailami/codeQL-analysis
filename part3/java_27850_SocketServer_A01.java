import java.io.IOException;
import java.net.StandardSocketOptions;
import java.nio.channels.Channels;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketChannel;

public class java_27850_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            SSLServerSocketChannel sslServerChannel = createSSLServerChannel(8080);
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerChannel.socket();
            sslServerSocket.setNeedClient(true);
            sslServerSocket.setReuseAddress(true);

            while (true) {
                SSLSocket clientSocket = (SSLSocket) sslServerChannel.accept();
                clientSocket.setNeedClient(true);
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static SSLServerSocketChannel createSSLServerChannel(int port) throws IOException {
        SSLServerSocketChannel sslServerChannel = SSLServerSocketChannel.open();
        sslServerChannel.bind(new java.net.InetSocketAddress(port));
        sslServerChannel.setNeedClient(true);
        sslServerChannel.setReuseAddress(true);
        return sslServerChannel;
    }

    private static class ClientHandler extends Thread {
        private final SSLSocketChannel clientChannel;

        public java_27850_SocketServer_A01(SSLSocketChannel clientChannel) {
            this.clientChannel = clientChannel;
        }

        @Override
        public void run() {
            try {
                Channels.newChannel(clientChannel).pipe(System.out);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}