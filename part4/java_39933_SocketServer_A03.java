import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_39933_SocketServer_A03 {
    private static final int PORT = 8080;
    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(10);

        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());
                Handler handler = new Handler(socket);
                executor.execute(handler);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    static class Handler implements Runnable {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_39933_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                this.writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // This is a placeholder for the injection code.
                    // In a real-world application, this should be sanitized and validated.
                    String response = processMessage(message);
                    writer.println(response);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        private String processMessage(String message) {
            // This is a placeholder for the injection code.
            // In a real-world application, this should be sanitized and validated.
            return "Server response: " + message;
        }
    }
}