import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_11951_SocketServer_A03 {
    private final ExecutorService executor;
    private final int port;

    public java_11951_SocketServer_A03(int port) {
        this.port = port;
        this.executor = Executors.newFixedThreadPool(10);
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");
            executor.execute(new SocketHandler(clientSocket));
        }
    }

    public static void main(String[] args) throws IOException {
        new SocketServer(8080).start();
    }

    private static class SocketHandler implements Runnable {
        private final Socket socket;

        public java_11951_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream input = socket.getInputStream();
                 OutputStream output = socket.getOutputStream()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                PrintWriter writer = new PrintWriter(output, true);
                String message;
                while ((message = reader.readLine()) != null) {
                    if (message.equals("exit")) {
                        writer.println("Goodbye!");
                        break;
                    } else if (isUnsafe(message)) {
                        writer.println("Invalid message, please enter a valid message");
                    } else {
                        writer.println("Message received: " + message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean isUnsafe(String message) {
            // Add your security-sensitive operations here, e.g.,
            // - Checking if the message contains SQL injections
            // - Checking if the message contains command injection
            // - Checking if the message contains file inclusion
            // - Checking if the message contains cross-site scripting (XSS)
            // - etc...
            // For the sake of simplicity, we'll just return false for now.
            return false;
        }
    }
}