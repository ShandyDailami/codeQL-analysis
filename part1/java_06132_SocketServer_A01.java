import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_06132_SocketServer_A01 {

    private final ExecutorService executor;
    private final ServerSocket server;

    public java_06132_SocketServer_A01(int port) throws IOException {
        server = new ServerSocket(port);
        executor = Executors.newCachedThreadPool();
    }

    public void startServer() {
        System.out.println("Server started on port " + server.getLocalPort());

        while (!Thread.currentThread().isInterrupted()) {
            try {
                handleRequest(server.accept());
            } catch (IOException e) {
                System.err.println("Unable to accept connection from client " + e);
                break;
            }
        }
    }

    private void handleRequest(Socket clientSocket) throws IOException {
        System.out.println("Handling client connection " + clientSocket.getRemoteSocketAddress());
        executor.execute(new SocketHandler(clientSocket));
    }

    public void shutDown() throws IOException {
        server.close();
        executor.shutdown();
    }

    private static class SocketHandler implements Runnable {
        private final Socket socket;

        public java_06132_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream input = socket.getInputStream(); OutputStream output = socket.getOutputStream()) {
                int request;
                while ((request = input.read()) != -1) {
                    output.write(request);
                }
            } catch (IOException e) {
                System.err.println("Error handling client " + socket.getRemoteSocketAddress() + ": " + e.getMessage());
            } finally {
                socket.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(8189);
        server.startServer();
    }
}