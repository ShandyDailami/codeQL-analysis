import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_38900_SocketServer_A03 {

    private static SSLServerSocket serverSocket;
    private static Socket clientSocket;
    private static SSLSocket sslSocket;
    private static KeyStore keyStore;
    private static KeyStorePassword keystorePassword;
    private static SSLServerSocketFactory sslServerSocketFactory;
    private static KeyManagerFactory keyManagerFactory;

    public static void main(String[] args) throws Exception {
        initServer();
        secureServer();
    }

    private static void initServer() throws Exception {
        String keyStorePath = "/path/to/your/keystore.jks";
        String keyStorePasswordPath = "/path/to/your/keystore-password.txt";
        String keyPassword = "yourpassword";

        keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream(keyStorePath), keyPassword.toCharArray());
        keystorePassword = new KeyStorePassword(keyStore, keyPassword.toCharArray());

        keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, keystorePassword.getPassword());

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8443);
        serverSocket.setNeedClientAuth(true);

        sslServerSocketFactory = sslServerSocketFactory.createServerSocketFactory(new SSLContext(keyManagerFactory));
    }

    private static void secureServer() throws Exception {
        while (true) {
            clientSocket = serverSocket.accept();
            sslSocket = (SSLSocket) sslServerSocketFactory.createSocket(clientSocket, clientSocket.getLocalPort());
            sslSocket.startHandshake();

            // Handle the client here

            sslSocket.close();
        }
    }
}