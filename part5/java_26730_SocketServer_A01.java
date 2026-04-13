import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_26730_SocketServer_A01 {
    private static final int PORT = 4445;
    private static ExecutorService executorService;

    public static void main(String[] args) {
        executorService = Executors.newFixedThreadPool(10);

        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                System.out.println("Waiting for client...");
                Socket client = server.accept();
                System.out.println("Client accepted!");

                executorService.execute(new ClientHandler(client));
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            executorService.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket client;

        public java_26730_SocketServer_A01(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                 PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    if (message.equals("exit")) {
                        out.println("Goodbye!");
                        break;
                    } else {
                        out.println("Hello, client!");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}