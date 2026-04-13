import java.io.IOException;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_33508_SocketServer_A08 {

    private static final String KEYSTORE = "truststore.jks"; // truststore
    private static final String KEYSTORE_PASSWORD = "password"; // password for keystore
    private static final String KEY_PASSWORD = "password"; // password for keymanager

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            // create a keystore and load our certificate into it
            KeyStore keystore = KeyStore.getInstance("JKS");
            keystore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(KEYSTORE), KEYSTORE_PASSWORD.toCharArray());

            // create a key manager factory using our keystore and password
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
            keyManagerFactory.init(keystore, KEY_PASSWORD.toCharArray());

            // create a SSLServerSocketFactory using our key manager factory
            SSLServerSocketFactory sslServerSocketFactory = new SSLServerSocketFactory(keyManagerFactory);

            // create a SSLServerSocket
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(443);

            while (true) {
                // accept a client
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                // handle client
                ClientHandler handler = new ClientHandler(clientSocket);
                handler.start();
            }
        } catch (KeyStoreException | CertificateException | IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) serverSocket.close();
        }
    }
}