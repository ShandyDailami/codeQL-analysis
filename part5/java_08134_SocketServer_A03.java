import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketChannel;

public class java_08134_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        int port = 12345; // Change this to the port you want to listen on

        // Create a server socket for client connections
        SSLServerSocketChannel serverSocketChannel = SSLServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);

        // Create a server socket for SSL
        SSLServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.setNeedClientAuth(true);

        while (true) {
            SocketChannel clientChannel = serverSocketChannel.accept();
            clientChannel.configureBlocking(false);

            // Negotiate SSL connection
            SSLServerSocket sslServerSocket = (SSLServerSocket) serverSocketChannel.accept();
            sslServerSocket.accept();

            // Perform operations on the SSL connection
            // ...

            clientChannel.close();
        }
    }
}