import java.io.IOException;
import java.net.InetSocketAddress;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_23576_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
        sslServerSocket.setNeedClientAuth(true);

        System.out.println("Waiting for client authentication");

        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
        sslSocket.startHandshake();

        System.out.println("Client " + sslSocket.getRemoteSocketAddress() + " authenticated successfully");

        sslServerSocket.close();
        sslSocket.close();
    }
}