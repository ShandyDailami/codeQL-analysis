import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_02175_SocketServer_A03 {
    private static final int PORT = 8080;
    private static final int NUMBER_OF_THREADS = 10;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket client = server.accept();
                System.out.println("Client " + client.getRemoteSocketAddress() + " connected");
                executorService.execute(new SocketHandler(client));
            }
        } catch (IOException ex) {
            System.out.println("Server caught an exception: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    static class SocketHandler implements Runnable {
        private Socket client;

        public java_02175_SocketServer_A03(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try (PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {
                out.println("Connected to client");
                while (true) {
                    String message = client.getInputStream().readUTF();
                    System.out.println("Received: " + message);
                    out.println("Echo: " + message);
                }
            } catch (IOException ex) {
                System.out.println("Client disconnected: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}