import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_22618_SocketServer_A08 {
    private static final int PORT = 12345;
    private static final String REMOTE_HOST = "localhost";
    private static final int MAX_THREADS = 10;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREADS);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                Runnable worker = new SocketHandler(in, out);
                executorService.submit(worker);
            }
        } catch (IOException e) {
            System.err.println("IOException occurred: " + e);
        } finally {
            executorService.shutdown();
        }
    }

    private static class SocketHandler implements Runnable {
        private DataInputStream in;
        private DataOutputStream out;

        public java_22618_SocketServer_A08(DataInputStream in, DataOutputStream out) {
            this.in = in;
            this.out = out;
        }

        @Override
        public void run() {
            try {
                byte[] buffer = new byte[1024];
                while (true) {
                    int bytesRead = in.read(buffer);
                    if (bytesRead < 0) {
                        break;
                    }

                    String message = new String(buffer, 0, bytesRead);
                    System.out.println("Received: " + message);

                    // Encrypt the message and send it back to the client
                    byte[] encryptedMessage = encryptMessage(message);
                    out.write(encryptedMessage);
                    out.flush();
                }
            } catch (IOException e) {
                System.err.println("IOException occurred while reading from client: " + e);
            }
        }

        private byte[] encryptMessage(String message) {
            // Here you can implement your own encryption logic.
            // This is just a placeholder for now.
            return message.getBytes();
        }
    }
}