import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;

public class java_40692_SocketServer_A01 {

    private static final String ALGORITHM = "PBEWithMD5AndDES";
    private static final String SECRET = "mySecret1234"; // should be stored securely

    public static void main(String[] args) throws Exception {
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey key = secretKeyFactory.generateKey(new PBEKeySpec(SECRET.toCharArray(), SECRET.toCharArray(), 128, 128));

        SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(12345, null, key, true);
        SSLSocket clientSocket = (SSLSocket) serverSocket.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        OutputStream out = clientSocket.getOutputStream();

        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Received: " + message);
            out.write(("Echo: " + message + "\n").getBytes());
        }

        clientSocket.close();
    }
}