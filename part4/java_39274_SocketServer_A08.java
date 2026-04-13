import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_39274_SocketServer_A08 {
    private static final int PORT = 5000;
    private static ExecutorService executor;

    public static void main(String[] args) {
        System.out.println("Starting server...");

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            executor = Executors.newCachedThreadPool();
            while (true) {
                System.out.println("Waiting for connection...");
                Socket socket = serverSocket.accept();
                System.out.println("Connected to " + socket.getRemoteSocketAddress());
                handleConnection(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void handleConnection(Socket socket) {
        executor.execute(new ClientHandler(socket));
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_39274_SocketServer_A08(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    writer.println("Message received");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}