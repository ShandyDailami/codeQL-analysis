import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_05559_SocketServer_A03 {
    private ExecutorService executor;

    public java_05559_SocketServer_A03(int port) {
        executor = Executors.newFixedThreadPool(50);
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("Server started on port " + port);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");
                executor.execute(new ClientHandler(socket));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            server.close();
            executor.shutdown();
        }
    }

    private class ClientHandler implements Runnable {
        private Socket socket;

        public java_05559_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    System.out.println("Received: " + clientMessage);

                    // Injecting a code injection here.
                    // For example, it's a common SQL injection.
                    if (clientMessage.contains("' OR '1'='1")) {
                        System.out.println("SQL Injection attempt detected");
                    }

                    // Simple echo
                    writer.println("Server: " + clientMessage);
                    writer.flush();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new SocketServer(8080);
    }
}