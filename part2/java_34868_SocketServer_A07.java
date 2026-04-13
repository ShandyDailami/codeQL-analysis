import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_34868_SocketServer_A07 {
    private static final int PORT = 12345;
    private static ExecutorService executorService;

    public static void main(String[] args) {
        executorService = Executors.newFixedThreadPool(10);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                executorService.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public java_34868_SocketServer_A07(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                String request;
                while ((request = in.readLine()) != null) {
                    System.out.println("Received: " + request);

                    // Authentication code here.
                    // For simplicity, we'll just check if the request is "auth".
                    if ("auth".equals(request)) {
                        out.println("Auth successful");
                    } else {
                        out.println("Auth failed");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}