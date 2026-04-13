import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.Certificate;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class java_42121_SocketServer_A07 {

    private static final String KEYSTORE = "src/main/resources/ssl/server.keystore";
    private static final String KEYPASSWORD = "password";
    private static final String TRUSTSTORE = "src/main/resources/ssl/server.truststore";
    private static final String TRUSTPASSWORD = "password";
    private static final String SSL_PROTOCOL = "SSL";
    private static final int PORT = 8443;

    public static void main(String[] args) throws Exception {

        SSLContext sslcontext = createSSLContext();
        SSLServerSocket serverSocket = (SSLServerSocket) sslcontext.getServerSocket(PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            SSLSocket sslSocket = (SSLSocket) socket.getSocket();
            sslSocket.setUseClientMode(true);
            sslSocket.setNeedClientAuth(true);
            sslSocket.setSSLContext(sslcontext);
            sslSocket.startHandshake();
            sslSocket.getSession().setAttributes(sslSocket.getSession().getSessionAttributes());
            sslSocket.getSession().setReadOnly();
            sslSocket.close();
        }
    }

    private static SSLContext createSSLContext() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(getClass().getResourceAsStream("/src/main/resources/ssl/server.keystore"), KEYPASSWORD.toCharArray());

        char[] passwords[] = KEYPASSWORD.toCharArray();
        keyStore.store(getClass().getResourceAsStream("/src/main/resources/ssl/server.keystore"), passwords);

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(new java.security.KeyStoreInputStream(getClass().getResourceAsStream("/src/main/resources/ssl/server.truststore"), TRUSTPASSWORD.toCharArray()));

        SSLContext sslcontext = SSLContext.getInstance(SSL_PROTOCOL);
        sslcontext.init(keyStore, trustManagerFactory.getTrustManagers(), null);

        return sslcontext;
    }
}