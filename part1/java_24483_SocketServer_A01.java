import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

public class java_24483_SocketServer_A01 {

    private static final String KEYSTORE = "keystore.jks";
    private static final String PASSWORD = "password";
    private static final int PORT = 12345;

    public static void main(String[] args) throws KeyStoreException, CertificateException, IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(null, PORT);

        KeyStore keyStore = KeyStore.getInstance("JKS");
        char[] password = PASSWORD.toCharArray();
        keyStore.load(SecureServer.class.getResourceAsStream("/keystore.jks"), password);

        System.out.println("Server started. Waiting for client on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create a new SSLSocket and wrap it with a SecureSocket
            SSLSocket sslSocket = (SSLSocket) socket.createChannel(socket.getInetAddress());

            // Initialize the SSLSocket with the KeyStore
            sslSocket.setSSLSocket(sslSocket);
            sslSocket.setNeedClientAuth(true);
            sslSocket.startHandshake();

            // Continue with communication using the SSLSocket
            // ...
        }
    }
}