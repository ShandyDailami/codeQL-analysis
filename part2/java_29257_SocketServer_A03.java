import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_29257_SocketServer_A03 {
    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(10);

        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server started on port 8080");

            while (true) {
                Socket socket = server.accept();
                executor.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;

        public java_29257_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                String message;
                while ((message = in.readLine()) != null) {
                    if (isInjectionAttempt(message)) {
                        out.println("Injection attempt detected: " + message);
                        break;
                    }
                    out.println("Received: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean isInjectionAttempt(String message) {
            // TODO: Implement your security-sensitive operation here.
            // This is a placeholder.
            return false;
        }
    }
}