import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.PasswordAuthentication;

public class java_16908_SocketServer_A07 {

    private static final String KEYSTORE = "C:/path/to/your/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "yourKeystorePassword";
    private static final String TRUSTSTORE = "C:/path/to/your/truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "yourTruststorePassword";

    public static void main(String[] args) throws CertificateException, IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = createSSLServerSocket(8080);
            while (true) {
                Socket socket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) socket.createChannel();
                sslSocket.setNeedClientAuth(true);
                sslSocket.startHandshake();
                sslSocket.getSession().setAuthenticationLevel(Session.AUTH_CRITICAL);
                sslSocket.setNeedClientAuth(true);
                sslSocket.setSoTimeout(60000);
                System.out.println("New Client Connected");
                // Create a new handler thread for this client
                new HandlerThread(sslSocket).start();
            }
        } finally {
            serverSocket.close();
        }
    }

    private static ServerSocket createSSLServerSocket(int port) throws IOException {
        KeyManagerFactory kmf = getKeyManagerFactory();
        TrustManagerFactory tmf = getTrustManagerFactory();
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory.setKeyManager(kmf);
        sslServerSocketFactory.setTrustManager(tmf);
        return (ServerSocket) sslServerSocketFactory.createServerSocket(port);
    }

    private static KeyManagerFactory getKeyManagerFactory() throws IOException {
        return KeyManagerFactory.getInstance("SunJSSE", "SLF4JB1");
    }

    private static TrustManagerFactory getTrustManagerFactory() throws IOException {
        return TrustManagerFactory.getInstance("SunJSSE", "SLF4JB1");
    }
}