import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;

public class java_08313_SocketServer_A08 {
    private static final String AES = "AES";
    private static final String KEY = "0123456789012345"; // 128 bit key

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Get the input and output streams
            new Handler(socket).start();
        }
    }

    static class Handler extends Thread {
        private final Socket socket;
        private final String address;
        private final Cipher cipher;

        public java_08313_SocketServer_A08(Socket socket) {
            this.socket = socket;
            this.address = socket.getInetAddress().getHostAddress();
            this.cipher = Cipher.getInstance(AES);
            this.cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(KEY.getBytes(), AES));
        }

        @Override
        public void run() {
            try {
                // Receive the message
                byte[] received = new byte[1024];
                socket.getInputStream().read(received);

                // Decrypt the message
                byte[] decrypted = cipher.doFinal(received);
                String decryptedString = new String(decrypted);

                System.out.println("Received: " + decryptedString);

                // Send the response
                String response = "Hello client, your message was received!";
                byte[] sendBytes = response.getBytes();
                byte[] encrypted = cipher.doFinal(sendBytes);

                socket.getOutputStream().write(encrypted);
            } catch (Exception e) {
                e.printStackTrace();
            }

            socket.close();
        }
    }
}