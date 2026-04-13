import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_11112_SocketServer_A03 {
    private static ExecutorService executor;
    private static int port;

    public java_11112_SocketServer_A03(int port) {
        this.port = port;
        executor = Executors.newCachedThreadPool();
    }

    public void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());
            executor.execute(new ClientHandler(socket));
        }
    }

    public static void main(String[] args) throws IOException {
        new SocketServer(8080).startServer();
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_11112_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                // Prevent injection by sanitizing user input
                message = sanitize(message);
                writer.println("You said: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String sanitize(String input) {
        // Simple input sanitization for demonstration purposes
        return input.replace("<", "&lt;").replace(">", "&gt;").replace("(", "&lt;").replace(")", "&gt;");
    }
}