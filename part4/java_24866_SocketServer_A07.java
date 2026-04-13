import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.Key;
import java.security.SecureRandom;

public class java_24866_SocketServer_A07 {

    // AES encryption
    private static final String ALGORITHM = "AES";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("localhost", 1234));
        System.out.println("Server is listening on port 1234...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            Key key = generateKey();
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);

            // Send the key to the client
            socket.getOutputStream().write(key.getEncoded());

            // Now the client and server can communicate with each other
            while ((socket.getInputStream().read()) != -1) ;
            socket.close();
        }
    }

    private static Key generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(new SecureRandom());
        SecretKey secretKey = keyGenerator.generateKey();
        return new SecretKeySpec(secretKey.getEncoded(), ALGORITHM);
    }
}