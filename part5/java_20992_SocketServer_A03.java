import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_20992_SocketServer_A03 {

    private static final String SERVER_KEYSTORE = "server.keystore";
    private static final String SERVER_KEYSTORE_PASSWORD = "server.keystore.password";
    private static final String CLIENT_KEYSTORE = "client.keystore";
    private static final String CLIENT_KEYSTORE_PASSWORD = "client.keystore.password";

    public static void main(String[] args) throws IOException, CertificateException {
        KeyStore serverKeystore = KeyStore.getInstance("JKS");
        serverKeystore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(SERVER_KEYSTORE), SERVER_KEYSTORE_PASSWORD.toCharArray());

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8443, null, serverKeystore, CLIENT_KEYSTORE_PASSWORD);
        sslServerSocket.setNeedClientAuth(true);

        while (true) {
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.setNeedClientAuth(true);

            System.out.println("Client " + sslSocket.getRemoteSocketAddress() + " connected.");

            // Here you can process the received data using SSLSocket
            // For example, here we simply close the connection
            sslSocket.close();
        }
    }
}