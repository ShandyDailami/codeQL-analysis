import java.io.IOException;
import java.net.InetAddress;
import java.net.SecureSocketServerSocket;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class java_20943_SocketServer_A08 {

    private static final String ALGORITHM = "RSA";

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
        keyPairGenerator.initialize(1024);

        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        SecureSocketServerSocket serverSocket = new SecureSocketServerSocket(8080, null, privateKey);
        serverSocket.setReuseAddress(true);

        while (true) {
            InetAddress clientAddress = serverSocket.getInetAddress();
            int port = serverSocket.getLocalPort();
            System.out.println("Accepted connection from " + clientAddress + " port " + port);

            // TODO: Handle the connection (e.g., read and write messages)
        }
    }
}