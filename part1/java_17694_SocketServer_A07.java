import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_17694_SocketServer_A07 {
    private static final String KEYSTORE_PATH = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "password_for_keystore";
    private static final String TRUSTSTORE_PATH = "path_to_your_truststore";
    private static final String TRUSTSTORE_PASSWORD = "password_for_truststore";

    public static void main(String[] args) throws IOException, CertificateException {
        KeyStore keystore = KeyStore.getInstance("JKS");
        keystore.load(SecureSocketServer.class.getResourceAsStream(KEYSTORE_PATH), KEYSTORE_PASSWORD.toCharArray());

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(443, null, keystore, TRUSTSTORE_PASSWORD.toCharArray());

        System.out.println("Server started");
        while (true) {
            Socket socket = sslServerSocket.accept();
            SSLSocket sslSocket = (SSLSocket) socket.createChannel();
            sslSocket.setNeedClientAuthentication(true);
            InetAddress ip = sslSocket.getInetAddress();
            System.out.println("Client IP: " + ip.getHostAddress());
            new Handler(sslSocket).start();
        }
    }
}