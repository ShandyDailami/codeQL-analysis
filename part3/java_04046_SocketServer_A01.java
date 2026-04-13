import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_04046_SocketServer_A01 {
    private static final int DEFAULT_PORT = 8080;
    private static final String DEFAULT_HOST = "localhost";

    private final ExecutorService executor;
    private final ServerSocket serverSocket;

    public java_04046_SocketServer_A01() throws IOException {
        this(DEFAULT_PORT);
    }

    public java_04046_SocketServer_A01(int port) throws IOException {
        executor = Executors.newCachedThreadPool();
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                handle(serverSocket.accept());
            } catch (IOException e) {
                break;
            }
        }
    }

    private void handle(Socket socket) throws IOException {
        executor.execute(new SocketHandler(socket));
    }

    private static class SocketHandler implements Runnable {
        private final Socket socket;

        public java_04046_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream input = socket.getInputStream();
                 OutputStream output = socket.getOutputStream()) {

                // Read request
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String request = reader.readLine();
                System.out.println("Received request: " + request);

                // Write response
                PrintWriter writer = new PrintWriter(output, true);
                writer.println("HTTP/1.1 200 OK");
                writer.println("Content-Type: text/plain;charset=utf-8");
                writer.println();
                writer.println("Hello, client!");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer();
        server.start();
    }
}