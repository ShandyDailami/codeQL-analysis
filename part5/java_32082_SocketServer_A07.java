import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_32082_SocketServer_A07 {

    private static final String CLIENT_KEYSTORE = "client.keystore";
    private static final String CLIENT_KEYSTORE_PASSWORD = "password";
    private static final String SERVER_KEYSTORE = "server.keystore";
    private static final String SERVER_KEYSTORE_PASSWORD = "password";
    private static final String ALGORITHM = "SunJSSE";

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
        serverSocket.setNeedClientAuth(true);

        KeyStore clientKeystore = KeyStore.getInstance(KeyStore.getDefaultType());
        clientKeystore.load(new FileInputStream(CLIENT_KEYSTORE), CLIENT_KEYSTORE_PASSWORD.toCharArray());

        KeyStore serverKeystore = KeyStore.getInstance(KeyStore.getDefaultType());
        serverKeystore.load(new FileInputStream(SERVER_KEYSTORE), SERVER_KEYSTORE_PASSWORD.toCharArray());

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(ALGORITHM);
        keyManagerFactory.init(serverKeystore, SERVER_KEYSTORE_PASSWORD.toCharArray());

        SSLServerCertificateExtensionManager certificateManager = SSLServerCertificateExtensionManager.getDefault();
        certificateManager.setExtensions({new SSLServerCertificateExtension(new BasicSSLCipherSuite("SSLv3"))});

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory, certificateManager, null);

        Socket socket = null;
        while ((socket = serverSocket.accept()) != null) {
            SSLSocket sslSocket = (SSLSocket) sslContext.wrapSocket(socket);
            sslSocket.startHandshake();

            // Perform authentication here, for example, check if the client certificate is valid
            X509Certificate clientCertificate = sslSocket.getLocalCertificate();
            // ...

            // Continue with communication on the secure socket
            // ...

            sslSocket.close();
        }

        serverSocket.close();
    }
}