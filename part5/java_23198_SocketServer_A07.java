import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.security.KeyStore;
import java.security.cert.Certificate;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.ServerSocket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLServerSocket;

public class java_23198_SocketServer_A07 {

    private static final String KEYSTORE_PATH = "path_to_your_keystore.jks";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String KEY_ALIAS = "your_key_alias";

    public static void main(String[] args) throws Exception {
        startSslServer();
    }

    private static void startSslServer() throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8443));

        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(getClass().getResourceAsStream(KEYSTORE_PATH), KEYSTORE_PASSWORD.toCharArray());

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, KEYSTORE_PASSWORD.toCharArray());

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

        SSLServerSocket sslsocket = (SSLServerSocket) sslContext.getServerSocket();
        SocketChannel clientSocket = sslsocket.accept();

        SSLEngine ssle = sslContext.createSSLEngine(clientSocket);
        ssle.setRemoteCertificate(clientSocket.getRemoteCertificate());

        // Here you would add your authentication logic
        // For example, let's assume that the client certificate's subject DN matches a certain value
        if (clientSocket.getRemoteCertificate().getSubjectDN().matches("CN=AUTHENTICATED_CLIENT")) {
            // Client successfully authenticated, proceed with communication...
        } else {
            // Client did not authenticate, close connection...
            clientSocket.close();
            sslsocket.close();
        }
    }
}