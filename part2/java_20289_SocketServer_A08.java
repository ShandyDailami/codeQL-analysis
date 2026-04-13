import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20289_SocketServer_A08 {

    private static final String ALGORITHM = "AES";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            new Handler(socket).start();
        }
    }

    static class Handler extends Thread {
        private final Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // generate a random 256 bit AES key
                KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
                SecretKey secretKey = keyGenerator.generateKey();
                byte[] key = secretKey.getEncoded();

                // encrypt the message
                String message = in.readUTF();
                Cipher cipher = Cipher.getInstance(ALGORITHM);
                cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, ALGORITHM));
                String encryptedMessage = new String(cipher.doFinal(message.getBytes()));

                // send the encrypted message
                out.writeUTF(encryptedMessage);
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}