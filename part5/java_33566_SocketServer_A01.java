import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_33566_SocketServer_A01 {
    private static final int PORT = 8080;
    private static final int NUM_THREADS = 5;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                Handler handler = new Handler(clientSocket, executorService);
                handler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}