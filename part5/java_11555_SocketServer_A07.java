import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class java_11555_SocketServer_A07 {

    private static final String KEYSTORE_PATH = "/path/to/your/keystore";
    private static final String KEYSTORE_PASSWORD = "yourKeystorePassword";
    private static final String KEY_PASSWORD = "yourKeyPassword";

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory.setKeystorePath(KEYSTORE_PATH);
        sslServerSocketFactory.setKeystorePass(KEYSTORE_PASSWORD.toCharArray());
        sslServerSocketFactory.setKeyPass(KEY_PASSWORD.toCharArray());

        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

        while (true) {
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            SSLSocketFactory sslSocketFactory = sslSocket.getSocketFactory();

            X509Certificate certificate = (X509Certificate) sslSocket.getSession().getPeerCertificate();
            System.out.println("Client Certificate: " + certificate.toString());

            Thread thread = new Thread(new SocketHandler(sslSocketFactory, sslServerSocket));
            thread.start();
        }
    }

    static class SocketHandler implements Runnable {
        private final SSLSocketFactory sslSocketFactory;
        private final SSLServerSocket sslServerSocket;

        public java_11555_SocketServer_A07(SSLSocketFactory sslSocketFactory, SSLServerSocket sslServerSocket) {
            this.sslSocketFactory = sslSocketFactory;
            this.sslServerSocket = sslServerSocket;
        }

        @Override
        public void run() {
            try {
                SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(sslServerSocket.getInetAddress(), 8080);
                sslSocket.setUseClientMode(true);

                // Here you can handle socket communication and authentication

                sslSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}