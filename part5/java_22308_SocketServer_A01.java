import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

public class java_22308_SocketServer_A01 {

    private static final String ALGORITHM = "RSA";
    private static final int KEY_SIZE = 1024;

    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
        keyGen.initialize(KEY_SIZE, new SecureRandom());

        KeyPair keyPair = keyGen.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        ServerSocket serverSocket = new ServerSocket(0); // Assumes a random available port
        System.out.println("Server is running on port: " + serverSocket.getLocalPort());

        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

        // Now, you can send your data using publicKey, which is sent to client
        // After receiving the data, you can decrypt it using privateKey

        serverSocket.close();
    }
}