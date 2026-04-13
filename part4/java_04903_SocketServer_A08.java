import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;

public class java_04903_SocketServer_A08 {
    private static final String KEY_STORE = "src/main/resources/mykeystore.jks";
    private static final String KEY_STORE_PASSWORD = "mypassword";
    private static final String KEY_PASSWORD = "mypassword";
    private static final String ALIAS = "myalias";
    private static final String SSL_PORT = "1234";

    public static void main(String[] args) throws IOException, CertificateException {
        SSLServer server = new SSLServer();
        server.start();
    }

    private void start() throws IOException, CertificateException {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;
        KeyStore keyStore = KeyStore.getInstance("JKS");
        try (InputStream inputStream = getClass().getResourceAsStream(KEY_STORE)) {
            keyStore.load(inputStream, KEY_STORE_PASSWORD.toCharArray());
        }
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, KEY_PASSWORD.toCharArray());
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) sslServerSocketFactory = new SSLServerSocketFactory(keyManagerFactory);
        sslServerSocketFactory.setKeyStorePassword(KEY_STORE_PASSWORD);
        serverSocket = new ServerSocket(Integer.parseInt(SSL_PORT));
        sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(serverSocket);
        while (true) {
            Socket clientSocket = sslServerSocket.accept();
            SSLSocket sslSocket = (SSLSocket) sslServerSocketFactory.createSocket(clientSocket, clientSocket.getInetAddress(), serverSocket.getLocalPort(), true);
            sslSocket.setNeedClientAuth(true);
            sslSocket.startHandshake();
            InputStream inputStream = sslSocket.getInputStream();
            OutputStream outputStream = sslSocket.getOutputStream();
            handleRequest(inputStream, outputStream);
            sslSocket.close();
       
        }
    }

    private void handleRequest(InputStream inputStream, OutputStream outputStream) throws IOException {
        // handle request and send response
    }
}