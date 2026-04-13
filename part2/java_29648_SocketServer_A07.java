import java.net.*;
import java.io.*;
import java.security.MessageDigest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_29648_SocketServer_A07 {

    private static final String HASH_ALGORITHM = "MD5";
    private static final int PORT = 12345;
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws Exception {

        // Create a thread pool for handling connections
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Start the server
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // Handling client's request
            executor.execute(new ClientHandler(socket));
        }
    }

    private static class ClientHandler implements Runnable {

        private Socket socket;

        public java_29648_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Read password from client
                String clientPassword = in.readUTF();

                // Authenticate client
                if (authenticate(clientPassword)) {
                    out.writeUTF("Authentication successful");
                } else {
                    out.writeUTF("Authentication failed");
                }

                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean authenticate(String password) {
            try {
                MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
                byte[] hash = md.digest(password.getBytes());

                return PASSWORD.equals(new String(hash));
            } catch (Exception e) {
                return false;
            }
        }
    }
}