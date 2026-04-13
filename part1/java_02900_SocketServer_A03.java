import java.io.IOException;
import java.net.SSLServerSocket;
import java.net.SSLServerSocketSocket;
import java.net.Socket;
import java.security.KeyStore;

public class java_02900_SocketServer_A03 {
    private static final String SSL_KEYSTORE = "path_to_your_keystore.jks";
    private static final String SSL_KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String SSL_TRUSTSTORE = "path_to_your_truststore.jks";
    private static final String SSL_TRUSTSTORE_PASSWORD = "your_truststore_password";

    public static void main(String[] args) throws IOException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(SSLServer.class.getResourceAsStream("/keystore.jks"), SSL_KEYSTORE_PASSWORD.toCharArray());

        SSLServerSocket sslServerSocket = null;

        try {
            sslServerSocket = (SSLServerSocket) SSLServerSocket.create(keyStore, SSL_KEYSTORE_PASSWORD.toCharArray());
            sslServerSocket.setNeedClientAuth(true);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        System.out.println("Waiting for client connection...");

        Socket socket = sslServerSocket.accept();
        System.out.println("Client connected!");

        // Handle client communication...

        socket.close();
        sslServerSocket.close();
    }
}