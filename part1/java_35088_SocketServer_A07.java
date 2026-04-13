import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_35088_SocketServer_A07 {
    private final ExecutorService executor;
    private final ServerSocket serverSocket;

    public java_35088_SocketServer_A07(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        executor = Executors.newCachedThreadPool();
    }

    public void startServer() {
        System.out.println("Server started.");
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());
                executor.execute(new SocketHandler(clientSocket));
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Failed to accept new connection.");
                break;
            }
        }
        executor.shutdown();
    }

    private class SocketHandler implements Runnable {
        private final Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_35088_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String request;
            try {
                request = in.readLine();
                if (request.equals("exit")) {
                    in.close();
                    out.close();
                    socket.close();
                } else {
                    String username = request.split(" ")[0];
                    String password = request.split(" ")[1];
                    if (authenticate(username, password)) {
                        out.println("Authentication successful.");
                    } else {
                        out.println("Authentication failed.");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean authenticate(String username, String password) {
            // Add your own authentication logic here. This is a placeholder
            return username.equals("admin") && password.equals("password");
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(5000);
        server.startServer();
    }
}