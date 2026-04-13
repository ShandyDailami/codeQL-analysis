import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_11683_SocketServer_A08 {
    private static final int PORT = 8080;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        executor = Executors.newCachedThreadPool();

        while (true) {
            Socket client = server.accept();
            executor.execute(new ClientHandler(client));
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    if (message.equals("exit")) {
                        out.println("Server shutting down...");
                        break;
                    } else {
                        out.println("Server's message: " + message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                clientSocket.close();
                executor.execute(new ShutdownHook(clientSocket));
            }
        }
    }

    static class ShutdownHook extends Thread {
        private final Socket clientSocket;

        ShutdownHook(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}