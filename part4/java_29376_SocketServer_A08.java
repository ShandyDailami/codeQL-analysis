import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class java_29376_SocketServer_A08 {

    private static final String TRANSFORMATION = "AES/CFB8/NoPadding";

    private Key key = new SecretKeySpec("0123456789ABCDEF".getBytes(), "AES");

    public void start(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String clientHello = in.readUTF();
            System.out.println("Received: " + clientHello);

            String response = authenticate(clientHello);
            out.writeUTF(response);
            out.flush();
        }
    }

    private String authenticate(String challenge) {
        byte[] challengeBytes = challenge.getBytes();
        byte[] responseBytes = encrypt(challengeBytes);

        return Base64.getEncoder().encodeToString(responseBytes);
    }

    private byte[] encrypt(byte[] data) {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, key);

        return cipher.doFinal(data);
    }

    public static void main(String[] args) throws IOException {
        SecureSocketServer server = new SecureSocketServer();
        server.start(1234);
    }
}