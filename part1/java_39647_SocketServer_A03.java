import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.Certificate;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_39647_SocketServer_A03 {

    public static void main(String[] args) {
        String keyStoreFile = "server.keystore";
        String keyStorePassword = "password";
        String keyPassword = "password";

        SSLServerSocketFactory sslServerSocketFactory = getSSLServerSocketFactory(keyStoreFile, keyStorePassword, keyPassword);

        try {
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setReuseAddress(true);

            while (true) {
                Socket socket = sslServerSocket.accept();
                System.out.println("Client connected");
                SSLSocket sslSocket = (SSLSocket) socket.createSocket(socket.getInetAddress(), socket.getPort(), InetAddress.getByName(socket.getLocalAddress()), socket.getLocalPort());

                // trust all certificates for validation
                sslSocket.setNeedClientAuth(true);

                // use custom Certificate
                sslSocket.setEnabledCertificateEntryTypes(sslSocket.getSupportedClientAuthTypes());

                Certificate[] certificates = sslSocket.getEnabledCertificateEntryTypes();

                // use custom Certificate
                sslSocket.setEnabledCertificateEntryTypes(certificates.length);

                sslSocket.setEnabledProtocols(new String[] { "TLSv1.2" });

                // set socket factory
                sslServerSocket.setSocketFactory(sslSocket.getSocketFactory());

                // start handling the socket
                handle(sslSocket);

                sslSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handle(SSLSocket socket) {
        // Handle the socket here...
    }

    private static SSLServerSocketFactory getSSLServerSocketFactory(String keyStoreFile, String keyStorePassword, String keyPassword) {
        SSLServerSocketFactory sslServerSocketFactory = null;

        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(keyStoreFile), keyStorePassword.toCharArray());

            keyStore.setPassword(keyPassword.toCharArray());

            Certificate[] certificates = keyStore.getCertificateChain("localhost");

            sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

            sslServerSocketFactory = new SSLServerSocketFactory(keyStore, new TrustStrategy(), sslServerSocketFactory);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sslServerSocketFactory;
    }

    private static class TrustStrategy implements javax.net.ssl.ssl.TrustStrategy {

        @Override
        public boolean isTrusted(Certificate[] chain, String authType) throws CertificateException, IOException {
            return true;
        }
    }
}