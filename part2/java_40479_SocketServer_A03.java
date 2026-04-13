import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_40479_SocketServer_A03 {
    private static ExecutorService executorService;

    public static void main(String[] args) {
        executorService = Executors.newCachedThreadPool();

        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                executorService.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_40479_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Sensitive operation: SQL Injection
                    String safeMessage = message.replace(";", "");

                    out.println("Reply: " + safeMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}