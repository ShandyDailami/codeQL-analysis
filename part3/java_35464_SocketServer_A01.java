import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_35464_SocketServer_A01 {
    private static final int DEFAULT_PORT = 12345;
    private static final String AUTH_USER = "admin";
    private static final String AUTH_PASSWORD = "password";

    private ExecutorService executor;
    private ServerSocket serverSocket;

    public java_35464_SocketServer_A01() {
        this(DEFAULT_PORT);
    }

    public java_35464_SocketServer_A01(int port) {
        executor = Executors.newFixedThreadPool(5);
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);
            startServer();
        } catch (IOException e) {
            System.err.println("Failed to bind port " + port);
        }
    }

    private void startServer() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());
                executor.execute(new ClientHandler(clientSocket));
            } catch (IOException e) {
                serverSocket.close();
                executor.shutdown();
                System.err.println("Failed to accept connection from client");
                break;
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;

        public java_35464_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                closeConnection();
            }
        }

        @Override
        public void run() {
            String request;
            try {
                while ((request = in.readLine()) != null) {
                    if ("exit".equals(request)) {
                        closeConnection();
                        break;
                    } else {
                        handleRequest(request);
                    }
                }
            } catch (IOException e) {
                closeConnection();
            }
        }

        private void handleRequest(String request) {
            String response;
            if (authenticate(request)) {
                response = "Hello, " + request + "\n";
            } else {
                response = "Access denied for " + request + "\n";
            }
            out.println(response);
            out.flush();
        }

        private boolean authenticate(String request) {
            String[] parts = request.split(" ");
            return AUTH_USER.equals(parts[0]) && AUTH_PASSWORD.equals(parts[1]);
        }

        private void closeConnection() {
            try {
                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                // Ignore close errors
            }
        }
    }
}