import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_09903_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try (SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8000)) {
            sslServerSocket.setNeedClientAuth(true);

            while (true) {
                try (SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept()) {
                    sslSocket.setNeedClientAuth(true);
                    System.out.println("New connection from " + sslSocket.getRemoteSocketAddress());
                }
            }
        }
    }
}