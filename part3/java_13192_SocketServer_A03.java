import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_13192_SocketServer_A03 {

    public static void main(String[] args) {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try (ServerSocketChannel serverSocketChannel = sslServerSocketFactory.createServerSocketChannel();
             ServerSocket serverSocket = (ServerSocket) serverSocketChannel.socket();) {

            serverSocket.setReuseAddress(true);
            serverSocket.bind(new InetSocketAddress(8080));

            while (true) {
                SocketChannel clientChannel = serverSocketChannel.accept();
                System.out.println("Accepted connection from " + clientChannel);
                new Thread(new SocketHandler(clientChannel)).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(SocketServerLegacy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class SocketHandler implements Runnable {

    private final SocketChannel clientChannel;

    public java_13192_SocketServer_A03(SocketChannel clientChannel) {
        this.clientChannel = clientChannel;
    }

    @Override
    public void run() {
        // Handle the client connection
    }
}