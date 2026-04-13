import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketChannel;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketChannel;

public class java_35662_SocketServer_A01 {
    private final int port;
    private final KeyStore keyStore;
    private final char[] password;

    public java_35662_SocketServer_A01(int port, String keyStoreFile, char[] password) throws Exception {
        this.port = port;
        this.keyStore = KeyStore.getInstance("JKS");
        this.keyStore.load(getClass().getResourceAsStream(keyStoreFile), password);
        this.password = password;
    }

    public void start() throws IOException {
        SSLServerSocketChannel sslChannel = (SSLServerSocketChannel) ServerSocketChannel.open();
        sslChannel.configureBlocking(false);

        SSLServerSocket sslServerSocket = (SSLServerSocket) sslChannel.accept();
        sslServerSocket.setNeedClientAuth(true);

        Key key = getKeyFromKeyStore();
        sslServerSocket.setKeyStore(keyStore);
        sslServerSocket.setNeedClientAuth(true);

        SSLSocket socket = (SSLSocket) sslServerSocket.accept();
        socket.setNeedClientAuth(true);

        SocketChannel channel = socket.getSocket().getChannel();
        channel.configureBlocking(false);

        while (true) {
            SocketChannel clientChannel = channel.accept();
            clientChannel.configureBlocking(false);

            // handle client connection
        }
    }

    private Key getKeyFromKeyStore() throws IOException, Exception {
        Certificate certificate = keyStore.getCertificate();
        return certificate.getPrivateKey();
    }

    public static void main(String[] args) throws Exception {
        new SecureSocketServer(8443, "keystore.jks", "password".toCharArray()).start();
    }
}