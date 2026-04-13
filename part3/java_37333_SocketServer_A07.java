import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_37333_SocketServer_A07 {

    private final int port;

    public java_37333_SocketServer_A07(int port) {
        this.port = port;
    }

    public void start() {
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(getClass().getResourceAsStream("/keystore.jks"), "password".toCharArray());
            KeyManager[] keyManagers = getKeyManager(keyStore);

            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);

            sslServerSocket.setNeedClientAuth(true);
            sslServerSocket.setKeyManagers(keyManagers);

            SSLSocket client = (SSLSocket) sslServerSocket.accept();
            client.startHandshake();

            // Here, you can use the client to communicate with the server.

            client.close();
            sslServerSocket.close();
        } catch (IOException | KeyStoreException e) {
            e.printStackTrace();
        }
    }

    private KeyManager[] getKeyManager(KeyStore keyStore) throws KeyStoreException, IOException, CertificateException {
        Certificate certificate = keyStore.getCertificate("alias");
        return new KeyManager[] {new KeyManagerCertificateAdapter(certificate, "password".toCharArray())};
    }

    public static void main(String[] args) {
        new SecureSocketServer(8443).start();
    }
}