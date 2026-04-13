import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_32488_SocketServer_A07 {
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newFixedThreadPool(5);
        ServerSocket server = new ServerSocket(8000);
        System.out.println("Server started on port 8000");
        while (true) {
            Socket clientSocket = server.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());
            executor.execute(new ClientHandler(clientSocket));
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_32488_SocketServer_A07(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    if ("auth".equals(message)) {
                        writer.println("Auth successful");
                    } else {
                        writer.println("Invalid password");
                    }
                }
            } catch (IOException e) {
                System.out.println("Client disconnected");
                executor.execute(new ClientHandler(clientSocket));
            }
        }
    }
}