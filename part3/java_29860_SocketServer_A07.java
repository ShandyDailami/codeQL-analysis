import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_29860_SocketServer_A07 {

    private static ExecutorService executorService;

    public static void main(String[] args) {
        executorService = Executors.newFixedThreadPool(10);
        startServer();
    }

    private static void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                Socket socket = serverSocket.accept();
                executorService.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;

        public java_29860_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
                String clientMessage = reader.readLine();
                if (clientMessage.equals("Hello")) {
                    writer.println("Hello, client");
                    System.out.println("Client authenticated successfully");
                } else {
                    throw new RuntimeException("Client authentication failed");
                }
            } catch (IOException e) {
                System.out.println("Client failed to authenticate");
            }
        }
    }
}