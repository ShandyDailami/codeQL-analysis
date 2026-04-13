import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class java_24668_SocketServer_A01 {
    private static final String SSL_PORT = "5001";

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory =
                (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(Integer.parseInt(SSL_PORT));

        sslServerSocket.setNeedClientAuth(true);

        while (true) {
            Socket sslSocket = sslServerSocket.accept();

            SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

            SSLSocket sockets = (SSLSocket) sslSocketFactory.createSocket(sslSocket.getInetAddress(), sslSocket.getPort());

            sockets.startHandshake();
            sockets.setNeedClientAuth(true);

            System.out.println("Client " + sockets.getRemoteSocketAddress() + " connected to " + sockets.getLocalSocketAddress());
        }
    }
}