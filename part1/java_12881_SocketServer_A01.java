import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

public class java_12881_SocketServer_A01 {

    public static void main(String[] args) throws IOException, KeyStoreException, CertificateException {
        // Create a server socket
        ServerSocketFactory socketFactory = SSLServerSocketFactory.newInstance(KeyStore.getDefaultKeyStore(), "mypass".toCharArray());
        socketFactory.setNeedClientAuth(true);
        ServerSocket serverSocket = (ServerSocket) socketFactory.createServerSocket(new InetSocketAddress(8080), 5);

        // Accept and handle connections
        while (true) {
            System.out.println("Waiting for client connection...");
            socketFactory.accept(serverSocket);
            System.out.println("Client connected!");
        }
    }
}