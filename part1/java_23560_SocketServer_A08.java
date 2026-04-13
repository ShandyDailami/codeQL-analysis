import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class java_23560_SocketServer_A08 {

    private static final String KEYSTORE_LOCATION = "/path/to/your/keystore";
    private static final String KEYSTORE_PASSWORD = "your-keystore-password";
    private static final String TRUSTSTORE_LOCATION = "/path/to/your/truststore";
    private static final String TRUSTSTORE_PASSWORD = "your-truststore-password";

    public static void main(String[] args) {
        try {
            TrustManagerFactory trustManagerFactory = getTrustManagerFactory();
            SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(8443);
            serverSocket.setNeedClientAuth(true);
            serverSocket.setTrustManager(trustManagerFactory.getTrustManager("PKIX"));
            while (true) {
                Socket socket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) socket.createChannel(socket.getInetAddress(), socket.getPort());
                sslSocket.setNeedClientAuth(true);
                sslSocket.setTrustManager(trustManagerFactory.getTrustManager("PKIX"));
                new ServerThread(sslSocket).start();
            }
        } catch (IOException | NoSuchAlgorithmException | KeyManagementException | CertificateException e) {
            e.printStackTrace();
        }
    }

    private static TrustManagerFactory getTrustManagerFactory() throws NoSuchAlgorithmException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(new java.security.KeyStoreProvider() {
            public java.security.KeyStore getKeyStore(String arg0, char[] arg1) throws KeyStoreException, IOException, CertificateException {
                return new java.security.PKIXKeyStore(java.net.URL.openStream("file:///" + TRUSTSTORE_LOCATION), TRUSTSTORE_PASSWORD.toCharArray());
            }
        });
        return trustManagerFactory;
    }

    private static class ServerThread extends Thread {
        private Socket socket;

        public java_23560_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            // handle client connection here
        }
    }
}