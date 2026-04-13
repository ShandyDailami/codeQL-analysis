import java.net.*;
import java.io.*;
import java.security.MessageDigest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_02342_SocketServer_A08 {
    private static final String SECRET = "secret";
    private static final int PORT = 8080;
    private ExecutorService executorService;

    public java_02342_SocketServer_A08() {
        executorService = Executors.newFixedThreadPool(5);
    }

    public void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port: " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

            // Process client request
            executorService.execute(new ClientHandler(clientSocket));
        }
    }

    private class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_02342_SocketServer_A08(Socket socket) {
            clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

                // Read client request
                String request = in.readLine();

                // Check request integrity
                if (checkRequestIntegrity(request)) {
                    System.out.println("Valid request from " + clientSocket.getRemoteSocketAddress());
                    // TODO: Process the request
                } else {
                    System.out.println("Invalid request from " + clientSocket.getRemoteSocketAddress());
                    // TODO: Handle request integrity failure
                }

                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean checkRequestIntegrity(String request) {
            String clientRequest = request; // Replace with actual request
            String serverRequest = hashRequest(clientRequest);

            return serverRequest.equals(hashRequest(clientRequest));
        }

        private String hashRequest(String request) {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hash = digest.digest(request.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        }
    }
}