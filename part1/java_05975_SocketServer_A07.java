import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class java_05975_SocketServer_A07 {

    private static final String ALGORITHM = "AES";
    private Key key;

    public java_05975_SocketServer_A07() throws Exception {
        this.key = generateKey();
    }

    private Key generateKey() throws Exception {
        Key key = KeyGenerator.getInstance(ALGORITHM).generateKey();
        return new SecretKeySpec(key, 0, key.getBytes().length, ALGORITHM, "BC");
    }

    public void startServer(int port) throws Exception {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            byte[] receivedBytes = new byte[1024];
            input.readFully(receivedBytes);

            byte[] encryptedMessage = encrypt(receivedBytes);
            output.writeBytes(encryptedMessage);

            socket.close();
        }
    }

    private byte[] encrypt(byte[] message) throws Exception {
        byte[] encryptedBytes = new byte[message.length];
        for (int i = 0; i < message.length; i++) {
            encryptedBytes[i] = encryptByte(message[i]);
        }
        return encryptedBytes;
    }

    private byte encryptByte(byte b) throws Exception {
        byte[] keyBytes = key.getEncoded();
        byte[] ivBytes = new byte[8];

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(keyBytes, ALGORITHM));

        return cipher.doFinal(b);
    }

    public static void main(String[] args) throws Exception {
        SecureServer server = new SecureServer();
        server.startServer(4444);
    }
}