import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.Certificate;

public class java_12646_SocketServer_A07 {
    private static final String KEYSTORE_FILE = "mykeystore";
    private static final char[] KEYSTORE_PASSWORD = "mypassword".toCharArray();

    public static void main(String[] args) throws Exception {
        // Load the keystore and truststore
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(ResourceLoader.getResource("classpath:" + KEYSTORE_FILE), KEYSTORE_PASSWORD);

        SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(4444, keyStore, KeyStore.getDefaultType(), 1024);

        System.out.println("Server started on port 4444");

        while (true) {
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.setNeedClientAuth(true);
            System.out.println("Client authenticated");

            // Get the certificate from the SSLSocket
            Certificate[] certificates = sslSocket.getSession().getPeerCertificates();

            // If the client has a certificate, process the request
            if (certificates.length > 0) {
                System.out.println("Client certificate found");
                processRequest(sslSocket);
            }

            sslSocket.close();
        }
    }

    private static void processRequest(SSLSocket sslSocket) {
        // Here you can add your processing code
    }
}