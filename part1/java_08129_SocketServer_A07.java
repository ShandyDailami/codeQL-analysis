import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_08129_SocketServer_A07 {
    private final ExecutorService executor;
    private final ServerSocket serverSocket;

    public java_08129_SocketServer_A07(int port) throws IOException {
        this.executor = Executors.newCachedThreadPool();
        this.serverSocket = new ServerSocket(port);
    }

    public void start() {
        System.out.println("Server started on port " + serverSocket.getLocalPort());

        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());

                // Handling client connection in separate thread
                executor.execute(new ClientHandler(clientSocket));
            } catch (IOException e) {
                System.err.println("Failed to accept client connection " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public void stop() throws IOException {
        serverSocket.close();
        executor.shutdown();
    }

    private class ClientHandler implements Runnable {
        private final Socket clientSocket;
        private final BufferedReader in;
        private final PrintWriter out;

        public java_08129_SocketServer_A07(Socket clientSocket) {
            this.clientSocket = clientSocket;
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                System.err.println("Failed to setup I/O for client " + clientSocket.getRemoteSocketAddress() + e.getMessage());
                return;
            }
        }

        @Override
        public void run() {
            try {
                String request;
                while ((request = in.readLine()) != null) {
                    if ("exit".equals(request)) {
                        clientSocket.close();
                        return;
                    }

                    if (!authenticate(request)) {
                        out.println("Login failed");
                        out.flush();
                        return;
                    }

                    out.println("Authenticated successfully");
                    out.flush();
                }
            } catch (IOException e) {
                System.err.println("Failed to handle client " + clientSocket.getRemoteSocketAddress() + e.getMessage());
            }
        }

        private boolean authenticate(String request) {
            // Here we'll just check if the request is "username:password".
            // In a real-world application, you'd likely use a secure authentication mechanism.
            String[] parts = request.split(":");
            if (parts.length != 2) {
                return false;
            }

            String username = parts[0];
            String password = parts[1];

            // For simplicity, let's assume we have a hardcoded user/password.
            // In a real-world application, you'd compare hashed passwords securely.
            if ("user".equals(username) && "password".equals(password)) {
                return true;
            }

            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        SecureServer server = new SecureServer(port);
        server.start();
    }
}