import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLServletException;

import org.apache.tomcat.util.http.ServerServlet;
import org.apache.tomcat.util.netji.SocketConnectFactory;

public class java_24757_SocketServer_A07 {

    private static final String KEYSTORE_LOCATION = "path/to/your/keystore";
    private static final String KEYSTORE_PASSWORD = "your_password";
    private static final String KEY_ALIAS = "your_alias";
    private static final int PORT = 8443;

    public static void main(String[] args) throws Exception {

        try (SSLServerSocket serverSocket = new SSLServerSocket(PORT)) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.setNeedClientAuth(true);
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(KEYSTORE_LOCATION), KEYSTORE_PASSWORD.toCharArray());

            clientSocket.setKeyStore(keyStore);
            clientSocket.setNeedClientAuth(true);
            clientSocket.startHandshake();
            if (clientSocket.getState().equals(SSLSocket.CLOSE_WAIT2)) {
                throw new SSLServletException("SSL Handshake failed, server sent CLOSE_WAIT2 state.");
            }
            // Continue with authentication...

            // Now you can safely use clientSocket for communication

        } catch (KeyStoreException | CertificateException | SSLServletException | java.io.IOException e) {
            e.printStackTrace();
        }
    }
}