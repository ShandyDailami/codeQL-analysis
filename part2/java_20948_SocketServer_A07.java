import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class java_20948_SocketServer_A07 {
    private static final String KEYSTORE_LOCATION = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";

    public static void main(String[] args) throws Exception {
        TrustManagerFactory trustManagerFactory = getTrustManagerFactory();
        SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(4001);
        serverSocket.setNeedClientAuth(true);
        serverSocket.setTrustManager(trustManagerFactory.getTrustManager("PKIX"));

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            SSLSocket sslSocket = (SSLSocket) socket.createChannel();
            sslSocket.setNeedClientAuth(true);
            sslSocket.startHandshake();
            if (sslSocket.getState().equals(Channel.STATE_FIRST_HANDSHAKE)) {
                sslSocket.setTrustManager(trustManagerFactory.getTrustManager("PKIX"));
            }

            X509Certificate[] chain = sslSocket.getSession().getPeerCertificateChain();
            System.out.println("Client certificate: " + chain[0].getSubjectDN().toString());
            sslSocket.close();
        }
    }

    private static TrustManagerFactory getTrustManagerFactory() throws Exception {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(null);
        return trustManagerFactory;
    }
}