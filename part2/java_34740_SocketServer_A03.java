import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_34740_SocketServer_A03 {

    private static ExecutorService executor = Executors.newFixedThreadPool(10);
    private static int clientCount = 0;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket client = server.accept();
            clientCount++;
            System.out.println("Client " + clientCount + " connected.");
            executor.execute(new ClientHandler(client));
        }
    }

    private static class ClientHandler implements Runnable {
        Socket socket;
        PrintWriter out;
        BufferedReader in;

        public java_34740_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                if ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    String sanitized = sanitizeInput(message);
                    System.out.println("Sanitized: " + sanitized);
                    out.println("Sanitized Message: " + sanitized);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String sanitizeInput(String input) {
            // Simulate injection by replacing special characters with their hexadecimal representation
            return input.replace("<", "&lt;").replace(">", "&gt;").replace("'", "&#039;");
        }
    }
}