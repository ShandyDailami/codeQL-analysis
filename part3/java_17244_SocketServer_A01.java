import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_17244_SocketServer_A01 {
    private static final int PORT = 12345;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        startServer();
    }

    private static void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);

        executor = Executors.newCachedThreadPool();

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            handleRequest(socket);
        }
    }

    private static void handleRequest(Socket socket) {
        executor.execute(new ClientHandler(socket));
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_17244_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                close();
            }
        }

        public void run() {
            try {
                out.println("Welcome to the server!");

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println("Server received: " + message);
                }
            } catch (IOException e) {
                close();
            }
        }

        private void close() {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                // Ignore exceptions
            }
        }
    }
}