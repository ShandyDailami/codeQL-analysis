import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

public class java_03861_SocketServer_A08 {

    private static final String KEYSTORE = "client.keystore";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String TRUSTSTORE = "client.truststore";
    private static final String TRUSTSTORE_PASSWORD = "password";

    public static void main(String[] args) throws KeyStoreException, CertificateException, IOException, KeyManagementException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.factory();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
        sslServerSocket.setNeedClientAuth(true);
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(loadKeyStore(KEYSTORE, KEYSTORE_PASSWORD), KEYSTORE_PASSWORD.toCharArray());
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyStore, null, null);
        sslServerSocket.setSSLContext(sslContext);

        Socket clientSocket = sslServerSocket.accept();
        System.out.println("Client Connected");
        OutputStream out = clientSocket.getOutputStream();
        InputStream in = clientSocket.getInputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
        clientSocket.close();
    }

    private static InputStream loadKeyStore(String keyStoreFile, String password) throws KeyStoreException, IOException, CertificateException {
        InputStream keyStoreInputStream = SocketServer.class.getResourceAsStream(keyStoreFile);
        char[] passwordArray = password.toCharArray();
        return new KeyStoreInputStream(keyStoreInputStream, passwordArray);
    }
}