import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_14115_SocketServer_A03 {

    private static ExecutorService executor;

    public static void main(String[] args) throws IOException, InterruptedException {
        executor = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server started on port 8189");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            executor.execute(new ClientHandler(socket));
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_14115_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                close();
            }
        }

        @Override
        public void run() {
            try {
                String request = reader.readLine();
                String response = encrypt(request);
                writer.println(response);
                System.out.println("Response sent to client: " + response);
            } catch (IOException e) {
                close();
            }
        }

        private void close() {
            try {
                if (socket != null) socket.close();
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String encrypt(String request) {
            // Simple encryption for demonstration purposes.
            // This is a naive form of encryption and should not be used for serious security purposes.
            StringBuilder sb = new StringBuilder();
            for (char c : request.toCharArray()) {
                sb.append((char) (c + 1));
            }
            return sb.toString();
        }

        private String decrypt(String response) {
            // Decryption is the inverse of encryption.
            StringBuilder sb = new StringBuilder();
            for (char c : response.toCharArray()) {
                sb.append((char) (c - 1));
            }
            return sb.toString();
        }
    }
}