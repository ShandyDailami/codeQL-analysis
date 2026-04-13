import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_14735_SocketServer_A01 {

    private ExecutorService executor;
    private int port;

    public java_14735_SocketServer_A01(int port) {
        this.port = port;
        executor = Executors.newFixedThreadPool(10);
    }

    public void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port: " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

            Future<?> future = executor.submit(new ClientHandler(clientSocket));
        }
    }

    public void stopServer() {
        executor.shutdown();
    }

    private class ClientHandler implements Runnable {

        private Socket clientSocket;

        public java_14735_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try (InputStream in = clientSocket.getInputStream();
                 OutputStream out = clientSocket.getOutputStream()) {

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                DataOutputStream writer = new DataOutputStream(out);

                String request = reader.readLine();
                System.out.println("Request received: " + request);

                if (isValidRequest(request)) {
                    writer.write("Access granted\n".getBytes());
                } else {
                    writer.write("Access denied\n".getBytes());
                }

                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Error handling client: " + e.getMessage());
            }
        }

        private boolean isValidRequest(String request) {
            // Here you would typically parse the request and verify its authenticity
            // This is a simple example that just checks if the request is "VALID"
            return request.equals("VALID");
        }
    }

    public static void main(String[] args) throws IOException {
        SecureServer server = new SecureServer(8080);
        server.startServer();
    }
}