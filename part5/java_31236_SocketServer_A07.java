import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_31236_SocketServer_A07 {
    private ExecutorService executor;
    private ServerSocket server;

    public java_31236_SocketServer_A07(int port) throws IOException {
        server = new ServerSocket(port);
        executor = Executors.newCachedThreadPool();
    }

    public void startServer() {
        System.out.println("Server started on port " + server.getLocalPort());
        while (true) {
            try {
                Socket clientSocket = server.accept();
                System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());
                handleClient(clientSocket);
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private void handleClient(Socket clientSocket) {
        executor.execute(new ClientHandler(clientSocket));
    }

    public static void main(String[] args) {
        try {
            SocketServer server = new SocketServer(8080);
            server.startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;

        public java_31236_SocketServer_A07(Socket clientSocket) {
            this.clientSocket = clientSocket;
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String request;
            try {
                while ((request = in.readLine()) != null) {
                    if ("auth".equalsIgnoreCase(request)) {
                        // Authentication code here. For simplicity, let's assume the user is authenticated.
                        out.println("Authenticated");
                        out.flush();
                    } else {
                        out.println("Unknown command");
                        out.flush();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            stopConnection();
        }

        private void stopConnection() {
            try {
                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}