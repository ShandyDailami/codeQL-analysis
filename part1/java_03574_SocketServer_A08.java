import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_03574_SocketServer_A08 {
    private static final int PORT = 8080;
    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(5);
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);
            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected");
                executor.execute(new ClientHandler(client));
            }
        } catch (IOException ex) {
            System.out.println("Error in server: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket client;

        public java_03574_SocketServer_A08(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try (OutputStream out = new BufferedOutputStream(client.getOutputStream())) {
                byte[] bytes = new byte[1024];
                while (client.getInputStream().read(bytes) != -1) {
                    // Here we simulate a security-sensitive operation related to A08_IntegrityFailure
                    // For simplicity, we just reverse the byte array
                    for (int i = 0; i < bytes.length / 2; i++) {
                        byte temp = bytes[i];
                        bytes[i] = bytes[bytes.length - i - 1];
                        bytes[bytes.length - i - 1] = temp;
                    }
                    out.write(bytes);
                    out.flush();
                }
            } catch (IOException ex) {
                System.out.println("Error in client: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}