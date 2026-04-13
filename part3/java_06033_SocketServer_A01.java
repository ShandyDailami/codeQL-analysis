import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_06033_SocketServer_A01 {

    private static SecretKey secretKey = new SecretKeySpec("KeyForEncryptionDecryption".getBytes(), "AES");

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(4444);

        while (true) {
            Socket clientSocket = serverSocket.accept();

            // Create new thread for each client
            new Thread(new SocketHandler(clientSocket)).start();
        }
    }

    static class SocketHandler implements Runnable {
        private Socket socket;
        private DataInputStream input;
        private DataOutputStream output;

        public java_06033_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                input = new DataInputStream(socket.getInputStream());
                output = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                // Receive data from client and decrypt
                String message = input.readUTF();
                String decryptedMessage = decryptMessage(message);

                // Send decrypted message back to client
                output.writeUTF(decryptedMessage);
                output.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String decryptMessage(String message) {
            byte[] encryptedMsg = message.getBytes();
            byte[] decryptedMsg = null;

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            decryptedMsg = cipher.doFinal(encryptedMsg);

            return new String(decryptedMsg);
        }
    }
}