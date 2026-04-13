import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.KeyManagerFactory;

public class java_27255_SocketServer_A03 {

    private static final String KEYSTORE = "src/main/resources/server.keystore";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String KEY_ALIAS = "alias";

    public static void main(String[] args) {
        SSLServerSocket sslServerSocket = null;
        try {
            sslServerSocket = (SSLServerSocket) new SSLServerSocket(4444);
            sslServerSocket.setNeedClientAuth(true);

            SSLContext sslContext = getSSLContext(KEYSTORE, KEYSTORE_PASSWORD, KEY_ALIAS);

            Socket socket = sslServerSocket.accept();
            SSLSocket sslSocket = (SSLSocket) socket;

            sslSocket.setEnabled(true);
            sslSocket.setUseClientMode(true);

            sslSocket.setSSLSocket(sslSocket);
            sslSocket.setSocket(sslServerSocket);

            InputStream is = sslSocket.getInputStream();
            OutputStream os = sslSocket.getOutputStream();

            // Rest of the code goes here

            sslServerSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static SSLContext getSSLContext(String keyStorePath, String password, String alias) {
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(ResourceLoader.getResource(keyStorePath), password.toCharArray());

            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(keyStore, password.toCharArray());

            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(kmf.getKeyManagers(), null, null);

            return sslContext;
        } catch (IOException | CertificateException | NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
            return null;
        }
    }
}