import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.Certificate;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManagerFactory;

public class java_01573_SocketServer_A08 {
    private static final String KEYSTORE_LOCATION = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String TRUSTSTORE_LOCATION = "path_to_your_truststore";
    private static final String TRUSTSTORE_PASSWORD = "your_truststore_password";

    public static void main(String[] args) throws Exception {
        KeyStore keystore = KeyStore.getInstance("JKS");
        keystore.load(ResourceLoader.getResource(KEYSTORE_LOCATION), KEYSTORE_PASSWORD.toCharArray());

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(new KeyStorePasswordCallback(keystore, TRUSTSTORE_PASSWORD.toCharArray()));

        SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(8080, (Socket server) => {
            InetAddress clientAddress = server.getInetAddress();
            System.out.println("Connected to " + clientAddress.toString());
            return new SSLSocket(server, trustManagerFactory, new KeyStorePasswordCallback(keystore, KEYSTORE_PASSWORD.toCharArray()));
        });

        serverSocket.setNeedClientAuth(true);

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            ClientHandler clientHandler = new ClientHandler(clientSocket);
            clientHandler.start();
        }
    }
}