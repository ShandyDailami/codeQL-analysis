import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_19112_SocketServer_A03 {
    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(10);

        ServerSocket server = null;
        try {
            server = new ServerSocket(8080);
            System.out.println("Server started at port: 8080");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                executor.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_19112_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (socket;
                 BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Here you can inject a malicious command, for instance, an XSS (Cross Site Scripting) attack.
                    // If the message contains a command, you should check and sanitize it, otherwise, you should ignore it.

                    String sanitizedMessage = sanitizeInput(message);
                    out.println("Echo: " + sanitizedMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String sanitizeInput(String input) {
            // TODO: Implement your own sanitization logic
            // This is a placeholder for a real-world application.
            return input;
        }
    }
}