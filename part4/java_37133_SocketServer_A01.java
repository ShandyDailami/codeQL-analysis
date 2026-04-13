import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_37133_SocketServer_A01 {

    private final int port;
    private final ExecutorService executor;

    public java_37133_SocketServer_A01(int port, int threadPoolSize) {
        this.port = port;
        this.executor = Executors.newFixedThreadPool(threadPoolSize);
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

            executor.execute(new SocketHandler(clientSocket));
        }
    }

    public void stop() {
        executor.shutdown();
    }

    private static class SocketHandler implements Runnable {
        private final Socket socket;

        public java_37133_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream in = socket.getInputStream();
                 OutputStream out = socket.getOutputStream()) {

                // Read the request
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String request = reader.readLine();
                System.out.println("Received: " + request);

                // Write a response
                String response = "Hello, client!";
                out.write(response.getBytes());
                out.newLine();
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(8080, 5);
        server.start();
    }
}