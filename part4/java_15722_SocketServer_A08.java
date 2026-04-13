import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.security.KeyStore;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

public class java_15722_SocketServer_A08 {

    private static final int PORT = 8080;
    private static final String KEYSTORE_LOCATION = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String TRUSTSTORE_LOCATION = "path_to_your_truststore";
    private static final String TRUSTSTORE_PASSWORD = "your_truststore_password";

    public static void main(String[] args) throws IOException, CertificateException {
        SSLServerSocketFactory sslServerSocketFactory = createSSLServerSocketFactory();
        SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
        serverSocket.setNeedClientAuth(true);

        // Set up SSLContext to validate the client
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new String[]{KEYSTORE_LOCATION}, null);

        while (true) {
            SSLSocket client = (SSLSocket) serverSocket.accept();
            client.setNeedClientAuth(true);

            // Validate the client
            sslContext.checkClientValidity();

            SocketChannel clientChannel = client.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (clientChannel.read(buffer) != -1) {
                buffer.flip();
                System.out.println(new String(buffer.array(), "UTF-8"));
                buffer.clear();
            }

            client.close();
        }
    }

    private static SSLServerSocketFactory createSSLServerSocketFactory() throws IOException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new java.io.FileInputStream(KEYSTORE_LOCATION), KEYSTORE_PASSWORD.toCharArray());

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        return (SSLServerSocketFactory) sslServerSocketFactory.createServerSocket(PORT, keyStore, TRUSTSTORE_PASSWORD.toCharArray(), new java.security.cert.Certificate[]{});
    }
}