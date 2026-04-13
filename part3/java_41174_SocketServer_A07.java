import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class java_41174_SocketServer_A07 {

    private static final String HASH_ALGORITHM = "SHA-256";
    private static final int AUTH_FAILURE_RETRIES = 3;
    private static final int BLOCK_SIZE = 8192;
    private Key key;

    public static void main(String[] args) {
        new SocketServer().start();
    }

    private void start() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(1234);
            System.out.println("Server started at " + serverSocket.getLocalSocketAddress());

            key = generateKey();

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected at " + socket.getRemoteSocketAddress());

                new Handler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try { serverSocket.close(); } catch (IOException e) { /* unable to do anything, just close */ }
            }
        }
    }

    private Key generateKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(HASH_ALGORITHM);
            keyGenerator.init(128); // for example purposes only
            return keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException | KeyStoreException e) {
            throw new IllegalStateException(e);
        }
    }

    private class Handler extends Thread {
        private final Socket socket;
        private final DataInputStream input;
        private final DataOutputStream output;
        private final Cipher cipher;
        private final byte[] buffer = new byte[BLOCK_SIZE];

        Handler(Socket socket) {
            this.socket = socket;
            try {
                input = new DataInputStream(socket.getInputStream());
                output = new DataOutputStream(socket.getOutputStream());
                cipher = Cipher.getInstance(HASH_ALGORITHM);
                cipher.init(Cipher.ENCRYPT_MODE, key);
            } catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override
        public void run() {
            int retries = AUTH_FAILURE_RETRIES;
            boolean success = false;
            while (!success && retries > 0) {
                try {
                    byte[] received = input.readNBytes(BLOCK_SIZE);
                    byte[] calculated = cipher.doFinal(received);
                    output.write(calculated);
                    success = Arrays.equals(received, calculated);
                    retries--;
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            }
            if (!success) {
                try { socket.close(); } catch (IOException e) { /* unable to do anything, just close */ }
            }
        }
    }
}