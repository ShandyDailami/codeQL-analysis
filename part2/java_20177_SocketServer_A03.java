import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.Certificate;

public class java_20177_SocketServer_A03 {
    private static final String KEY_STORE_TYPE = "JKS";
    private static final String KEY_STORE_PATH = "src/main/resources/keystore.jks";
    private static final String KEY_STORE_PASSWORD = "password";
    private static final String KEY_ALIAS = "alias";
    private static final String TRUST_STORE_PATH = "src/main/resources/truststore.jks";
    private static final String TRUST_STORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        SSLContext sslContext = getSSLContext();
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            SSLSocket socket = (SSLSocket) serverSocket.accept();
            socket.setNeedClientAuth(true);
            sslContext.getSession().setSessionID(socket.getSessionID());
            handleClient(socket);
        }
    }

    private static void handleClient(SSLSocket socket) throws Exception {
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        // read and write from/to client
    }

    private static SSLContext getSSLContext() throws Exception {
        KeyStore keyStore = KeyStore.getInstance(KEY_STORE_TYPE);
        keyStore.load(getClass().getResourceAsStream(KEY_STORE_PATH), KEY_STORE_PASSWORD.toCharArray());
        KeyStore trustStore = KeyStore.getInstance(TRUST_STORE_PATH);
        trustStore.load(getClass().getResourceAsStream(TRUST_STORE_PASSWORD), TRUST_STORE_PASSWORD.toCharArray());
        Certificate[] certificates = trustStore.getCertificateChain(KEY_ALIAS);
        return SSLContext.getInstance("SSL");
    }
}