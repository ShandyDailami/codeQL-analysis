import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;

public class java_05005_SocketServer_A03 {

    private static final String CLIENT_KEY_STORE = "client.jks";
    private static final String CLIENT_KEY_STORE_PASSWORD = "password";
    private static final String CLIENT_TRUST_STORE = "client.jks";
    private static final String CLIENT_TRUST_STORE_PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
        sslServerSocket.setNeedClientAuth(true);
        sslServerSocket.setWantClientAuth(true);

        while (true) {
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.setNeedClientAuth(true);
            sslSocket.setWantClientAuth(true);

            // Here you can handle the socket for secure communication

            sslSocket.close();
        }
    }
}