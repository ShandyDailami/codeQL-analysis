import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_41108_SocketServer_A03 {
    private final ExecutorService executor;
    private final ServerSocket server;

    public java_41108_SocketServer_A03(int port) throws IOException {
        server = new ServerSocket(port);
        executor = Executors.newCachedThreadPool();
    }

    public void startServer() {
        System.out.println("Server started on port " + server.getLocalPort());

        while (true) {
            try {
                Socket clientSocket = server.accept();
                System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());

                // Process the request and response
                executor.execute(new SocketHandler(clientSocket));

            } catch (IOException e) {
                server.close();
                System.out.println("Failed to accept new connection: " + e.getMessage());
                break;
            }
        }

        executor.shutdown();
    }

    private static class SocketHandler implements Runnable {
        private final Socket socket;
        private final BufferedReader reader;
        private final PrintWriter writer;

        public java_41108_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                this.writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                close(reader, writer, socket);
            }
        }

        @Override
        public void run() {
            String request;

            try {
                if ((request = reader.readLine()) != null) {
                    processRequest(request);
                }
            } catch (IOException e) {
                close(reader, writer, socket);
            }
        }

        private void processRequest(String request) {
            // Implement security-sensitive operations related to A03_Injection here
            // For example, use a safer implementation or sanitize the input

            // Send a response
            writer.println("Hello, client!");
            writer.flush();
        }

        private void close(Reader reader, Writer writer, Socket socket) {
            try {
                reader.close();
                writer.close();
                socket.close();
            } catch (IOException e) {
                System.out.println("Failed to close connection: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(8080);
        server.startServer();
    }
}