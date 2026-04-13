import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_39584_SocketServer_A03 {
    private static ExecutorService executor;

    public static void main(String[] args) {
        int port = 1234;
        executor = Executors.newFixedThreadPool(10);

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port: " + port);
            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected: " + client.getRemoteSocketAddress());
                executor.execute(new ClientHandler(client));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket client;

        public java_39584_SocketServer_A03(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                 PrintWriter writer = new PrintWriter(client.getOutputStream(), true)) {
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Client says: " + message);
                    String response = processMessage(message);
                    writer.println(response);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String processMessage(String message) {
            // This is where we would implement our injection attack.
            // We would not be calling a harmful function here, but just calling the
            // same function multiple times with different arguments to evade detection.
            return message + message + message;
        }
    }
}