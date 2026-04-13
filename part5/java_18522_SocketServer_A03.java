import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import javax.crypto.Cipher;

public class java_18522_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        KeyPair keyPair = generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Waiting for client...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        String message = dataInputStream.readUTF();
        System.out.println("Received: " + message);

        String encryptedMessage = encryptMessage(message, publicKey);
        dataOutputStream.writeUTF(encryptedMessage);
        dataOutputStream.flush();

        socket.close();
        serverSocket.close();
    }

    private static String encryptMessage(String message, PublicKey publicKey) throws Exception {
        byte[] decodedMessage = Base64.getDecoder().decode(message);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.setPublic(publicKey);
        byte[] encryptedMessage = cipher.doFinal(decodedMessage);
        return Base64.getEncoder().encodeToString(encryptedMessage);
    }

    private static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        return keyPairGenerator.generateKeyPair();
    }
}