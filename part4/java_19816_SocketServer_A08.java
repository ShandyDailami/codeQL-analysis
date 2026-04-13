import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_19816_SocketServer_A08 {
    private static final int PORT = 8080;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        // Create executor with a fixed thread pool
        executor = Executors.newFixedThreadPool(10);

        // Start server
        startServer();
    }

    private static void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected from " + clientSocket.getRemoteSocketAddress());

            // Create new thread for handling communication
            Handler handler = new Handler(clientSocket);
            executor.execute(handler);
        }
    }

    private static class Handler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_19816_SocketServer_A08(Socket socket) {
            this.socket = socket;

            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                // Ignore, can't do anything at this point
            }
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Here you can handle the received message securely
                    // ...
                }
            } catch (IOException e) {
                // Ignore, client closed the connection
            } finally {
                // Close connection
                try {
                    if (in != null) in.close();
                    if (out != null) out.close();
                    if (socket != null) socket.close();
                } catch (IOException e) {
                    // Ignore
                }
            }
        }
    }
}