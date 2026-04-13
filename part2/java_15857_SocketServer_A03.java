import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_15857_SocketServer_A03 {
    private static final int PORT = 8080;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        startServer();
        // This line will make the server run indefinitely
        while (true) {
            Thread thread = new Thread(new ClientHandler());
            thread.start();
        }
    }

    private static void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);
        executor = Executors.newFixedThreadPool(5);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());
            executor.execute(new ClientHandlerTask(socket));
        }
    }

    private static class ClientHandlerTask implements Runnable {
        private Socket socket;

        public java_15857_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                handle(socket.getInputStream(), socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void handle(InputStream input, OutputStream output) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            DataOutputStream writer = new DataOutputStream(output);

            String request = reader.readLine();
            String response;

            if (request != null) {
                // Simple echo for demonstration purposes
                response = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/plain; charset=UTF-8\r\n" +
                        "Content-Length: " + response.length() + "\r\n" +
                        "\r\n" +
                        response + "\r\n\r\n";

                writer.write(response.getBytes());
            }
        }
    }

    private static class ClientHandler implements Runnable {
        @Override
        public void run() {
            // Nothing to do here
        }
    }
}