import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

import javax.net.ServerSocketFactory;
import javax.net.SocketFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;

public class java_17741_SocketServer_A07 {
    private static final String SSL_PORT = "12345";

    public static void main(String[] args) throws CertificateException, KeyStoreException, IOException,
            NoSuchAlgorithmException, KeyManagementException {
        ServerSocketFactory sslsf = (ServerSocketFactory) SSLServerSocketFactory.getDefault();
        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("keystore.jks"), "password".toCharArray());
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(ks);

        SSLContext sslContext = SSLServerSocketFactory.createServerSocket(
                Integer.parseInt(SSL_PORT), null, ks, tmf).getServerSocket();

        SSLServerSocket serverSocket = (SSLServerSocket) sslsf.createServerSocket(Integer.parseInt(SSL_PORT));
        serverSocket.setReuseAddress(true);

        InetSocketAddress address = new InetSocketAddress(Integer.parseInt(SSL_PORT));
        InetSocketAddress mainAddress = new InetSocketAddress(address.getAddress(), 40000);

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.setReuseAddress(true);
            clientSocket.bind(mainAddress);
            System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

            // Create a new thread for handling the client request
            new HandlerThread(clientSocket, sslContext).start();
        }
    }
}