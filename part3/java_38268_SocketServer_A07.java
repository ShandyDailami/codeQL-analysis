import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_38268_SocketServer_A07 {
    public static void main(String[] args) throws IOException, CertificateException {
        // Create a KeyStore that contains our certificate and a key
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(SecureSocketServer.class.getResourceAsStream("/client.jks"), "password".toCharArray());

        // Setup SSLSocketFactory with our KeyStore and TrustStore
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory.setKeyStore(keyStore);
        sslServerSocketFactory.setKeyStorePassword("password");

        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8443, InetAddress.getByName("localhost"));

        while (true) {
            Socket socket = sslServerSocket.accept();
            System.out.println("New connection from: " + socket.getRemoteSocketAddress());

            SSLSocket sslSocket = (SSLSocket) sslServerSocketFactory.createSocket(socket, socket.getLocalSocketAddress(), true, false);
            sslSocket.setNeedClientAuth(true);

            // Now use sslSocket for communication
        }
    }
}