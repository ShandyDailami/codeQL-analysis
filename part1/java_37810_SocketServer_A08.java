import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_37810_SocketServer_A08 {
    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newCachedThreadPool();

        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket client = server.accept();
                System.out.println("Accepted connection from " + client.getRemoteSocketAddress());

                executor.execute(new ClientHandler(client));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket client;

        ClientHandler(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try (OutputStream out = new BufferedOutputStream(client.getOutputStream())) {
                out.write("Hello, client!".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}