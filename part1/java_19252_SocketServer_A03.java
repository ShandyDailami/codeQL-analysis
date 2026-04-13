import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_19252_SocketServer_A03 {
    private static ExecutorService executor;
    private static ServerSocket server;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();
        server = new ServerSocket(8080);
        System.out.println("Server started...");

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                handleRequest(socket);
            } catch (Exception e) {
                System.out.println("Error handling client connection: " + e.getMessage());
            }
        }
    }

    private static void handleRequest(Socket socket) {
        executor.execute(new ClientHandler(socket));
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_19252_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (Exception e) {
                System.out.println("Error setting up I/O for client connection: " + e.getMessage());
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    if (message.contains("password")) {
                        out.println("Access denied!");
                    } else {
                        out.println("Access granted!");
                    }
                    out.flush();
                }
            } catch (Exception e) {
                System.out.println("Error handling client request: " + e.getMessage());
            }
        }
    }
}