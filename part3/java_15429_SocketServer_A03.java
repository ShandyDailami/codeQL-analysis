import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_15429_SocketServer_A03 {

    public static void main(String[] args) throws IOException, CertificateException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
        sslServerSocket.setNeedClientAuth(true);

        while (true) {
            SocketChannel socketChannel = sslServerSocket.accept();
            SSLSocket sslSocket = (SSLSocket) socketChannel.accept();

            System.out.println("Client SSL connected!");
            sslSocket.setNeedClientAuth(true);

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            sslSocket.getInputStream().read(buffer.array());
            String request = new String(buffer.array(), "UTF-8");
            System.out.println("Request: " + request);

            String response = "Hello, Client!";
            sslSocket.getOutputStream().write(response.getBytes());
        }
    }
}