import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.cert.CertificateException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLServletContext;
import javax.net.ssl.ServerSocketFactory;
import javax.net.ssl.SSLContext;

public class java_10653_SocketServer_A01 {
    private static final Logger LOG = Logger.getLogger(SecureSocketServer.class.getName());

    private SSLServerSocket serverSocket;
    private SSLServletContext servletContext;

    public void start(int port) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) serverSocket.getSocketFactory();
        SSLSocket sslSocket = (SSLSocket) sslServerSocketFactory.createServerSocket(port);

        // Create SSL context and set key and certificates
        SSLContext context = SSLContext.getInstance("SSL");
        context.init(null, new java.security.cert.Certificate[]{}, null);

        // Set truststore
        context.setTruststore(java.security.cert.getTrustStore(java.security.cert.TrustStore.getDefaultType()));

        // Set key store
        context.setKeyStore(java.security.KeyStore.getInstance("JKS"), "password".toCharArray());

        servletContext = (SSLServletContext) context.createServletContext(null);

        servletContext.getRequestDispatcher("/").setAuthConstraint(new javax.security.auth.message.AuthConstraint(null));

        sslSocket.setSSLServletContext(servletContext);

        serverSocket.bind(new InetSocketAddress(port));

        // Start accepting client
        while (true) {
            SSLSocket client = (SSLSocket) serverSocket.accept();
            client.setSoTimeout(60 * 1000);
            // Here you would place the logic for handling secure client, e.g., reading/writing data
        }
    }

    public void stop() {
        try {
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(SecureSocketServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        try {
            SecureSocketServer server = new SecureSocketServer();
            server.start(12345);
        } catch (IOException ex) {
            Logger.getLogger(SecureSocketServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}