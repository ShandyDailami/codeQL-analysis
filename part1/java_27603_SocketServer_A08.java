import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;

public class java_27603_SocketServer_A08 {
    private static final String CLIENT_DIR = "src/main/resources/client.jks";
    private static final String TRUST_STORE_DIR = "src/main/resources/truststore.jks";
    private static final String KEY_STORE_PASSWORD = "password";
    private static final String TRUST_STORE_PASSWORD = "password";

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = createServerSocket(54321);
            while (true) {
                Socket socket = serverSocket.accept();
                SSLServerSocket sslServerSocket = (SSLServerSocket) serverSocket;
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

                // Get client's certificate
                Certificate[] certificates = sslSocket.getSession().getPeerCertificates();
                InetAddress clientAddress = certificates[0].getSubjectDN().toString().split("/")[1];
                System.out.println("Client IP: " + clientAddress.getHostAddress());

                // Handle connection here...
            }
        } catch (Exception e) {
            Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private static ServerSocket createServerSocket(int port) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = createSSLServerSocketFactory();
            ServerSocket serverSocket = sslServerSocketFactory.createServerSocket(port);
            serverSocket.setReuseAddress(true);
            return serverSocket;
        } catch (Exception e) {
            Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    private static SSLServerSocketFactory createSSLServerSocketFactory() {
        try {
            KeyManagerFactory keyManagerFactory = createKeyManagerFactory();
            TrustManagerFactory trustManagerFactory = createTrustManagerFactory();
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocketFactory.setKeyManager(keyManagerFactory);
            sslServerSocketFactory.setTrustManager(trustManagerFactory);
            return sslServerSocketFactory;
        } catch (Exception e) {
            Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    private static KeyManagerFactory createKeyManagerFactory() {
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(getClass().getResourceAsStream(CLIENT_DIR), KEY_STORE_PASSWORD.toCharArray());
            return KeyManagerFactory.getInstance("SunKSAPI");
        } catch (Exception e) {
            Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    private static TrustManagerFactory createTrustManagerFactory() {
        try {
            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(getClass().getResourceAsStream(TRUST_STORE_DIR), TRUST_STORE_PASSWORD.toCharArray());
            return TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        } catch (Exception e) {
            Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}