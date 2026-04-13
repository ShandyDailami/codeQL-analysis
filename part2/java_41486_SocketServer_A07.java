import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManagerFactory;

public class java_41486_SocketServer_A07 {

    private static final String KEYSTORE_LOCATION = "/path/to/your/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "yourpassword";
    private static final String KEY_ALIAS = "youralias";

    public static void main(String[] args) throws Exception {
        runServer(8080);
    }

    private static void runServer(int port) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            serverSocket = createServerSocket(port);

            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                clientSocket.startHandshake();

                // Authenticate the user
                AuthenticationHandler authHandler = new AuthenticationHandler();
                if (!authHandler.authenticate(clientSocket)) {
                    throw new IOException("Authentication failed");
                }

                OutputStream out = clientSocket.getOutputStream();
                String response = "Hello, you are authenticated!";
                out.write(response.getBytes());
                out.close();
            }
        } finally {
            serverSocket.close();
        }
    }

    private static SSLServerSocket createServerSocket(int port) {
        SSLServerSocketFactory sslServerSocketFactory = createSSLServerSocketFactory();
        SSLServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
            serverSocket.setNeedClientAuthentication(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return serverSocket;
    }

    private static SSLServerSocketFactory createSSLServerSocketFactory() {
        TrustManagerFactory tmf = createTrustManagerFactory();
        return (SSLServerSocketFactory) tmf.createServerSocketFactory();
    }

    private static TrustManagerFactory createTrustManagerFactory() {
        try {
            return TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        } catch (KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
            e.printStackTrace();
        }
        return null;
    }
}