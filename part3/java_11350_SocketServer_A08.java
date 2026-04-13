import java.net.*;
import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_11350_SocketServer_A08 {

    // Define your secret key
    private static final String KEY = "AESKey";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started.");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            // Create a new thread to handle the client
            new ClientHandler(socket).start();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_11350_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Encrypt the message
                String message = in.readLine();
                byte[] encrypted = encrypt(message, KEY);

                // Send the encrypted message
                out.writeBytes(encrypted + "\n");
                out.flush();

                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Method for AES encryption
        private byte[] encrypt(String data, String key) throws Exception {
            SecretKey secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(data.getBytes());
        }
    }
}