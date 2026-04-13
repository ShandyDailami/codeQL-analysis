import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_09879_SocketServer_A07 {
    private static final int PORT = 8080;
    private static final int MAX_CONNECTIONS = 10;
    private ExecutorService executor;

    public java_09879_SocketServer_A07() {
        executor = Executors.newFixedThreadPool(MAX_CONNECTIONS);
    }

    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client " + clientSocket.getInetAddress() + " connected");

                executor.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_09879_SocketServer_A07(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            // TODO: Add code to handle client requests, authenticate users, etc.
        }
    }

    public static void main(String[] args) {
        new SocketServer().startServer();
    }
}