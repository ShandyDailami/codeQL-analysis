import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_16407_SocketServer_A08 {

    private static ExecutorService executor;
    private static ServerSocket server;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();
        server = new ServerSocket(8080);
        System.out.println("Waiting for client on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");
            executor.execute(new SocketHandler(socket));
        }
    }

    static class SocketHandler implements Runnable {
        private Socket socket;

        public java_16407_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Encryption and decryption here
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                // Receive encrypted message from client
                byte[] encryptedMessage = input.readByteArray();

                // Decryption
                byte[] decryptedMessage = decrypt(encryptedMessage);

                // Send decrypted message back to client
                output.writeBytes(decryptedMessage);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private byte[] decrypt(byte[] encrypted) {
            // Implement your decryption logic here
            return encrypted;
        }
    }
}