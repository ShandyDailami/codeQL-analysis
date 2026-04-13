import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_23952_SocketServer_A01 {
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 1234;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        executor = Executors.newFixedThreadPool(10);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());
            ClientHandler clientHandler = new ClientHandler(clientSocket);
            executor.execute(clientHandler);
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;

        public java_23952_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                close();
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println("Echo: " + message);
                }
            } catch (IOException e) {
                close();
            }
        }

        private void close() {
            try {
                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                // Ignore errors
            }
        }
    }
}