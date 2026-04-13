import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.cert.CertificateException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_40991_SocketServer_A07 {

    private static final Logger LOG = Logger.getLogger(SecureSocketServer.class.getName());

    public static void main(String[] args) {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try {
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);

            LOG.info("Server started");
            while (true) {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                sslSocket.setNeedClientAuth(true);
                new Handler(sslSocket).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(SecureSocketServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CertificateException ex) {
            Logger.getLogger(SecureSocketServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static class Handler extends Thread {
        private SSLSocket sock;

        Handler(SSLSocket sock) {
            this.sock = sock;
        }

        @Override
        public void run() {
            // Read request from client
            // ...

            // Close the connection
            // ...
        }
    }
}