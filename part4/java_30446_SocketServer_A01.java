import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_30446_SocketServer_A01 {
    private static final String KEY_STORE = "mykeystore";
    private static final char[] KEY_STORE_PASSWORD = "mypass".toCharArray();
    private static final char[] PASSWORD = "mypass".toCharArray();

    public static void main(String[] args) throws IOException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(SecureServer.class.getResourceAsStream("/mykeystore.jks"), KEY_STORE_PASSWORD);

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        ServerSocket serverSocket = (ServerSocket) sslServerSocketFactory.createServerSocket(1234, keyStore, PASSWORD);

        while (true) {
            SSLSocket sslSocket = (SSLSocket) serverSocket.accept();
            sslSocket.setSoTimeout(10000);

            InetAddress clientAddress = sslSocket.getInetAddress();
            System.out.println("Accepted connection from " + clientAddress.toString());

            // Perform client-side secure communications here

            sslSocket.close();
        }
    }
}