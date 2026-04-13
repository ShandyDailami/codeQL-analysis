import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_20226_SocketServer_A03 {
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server is listening on port 1234");

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getRemoteSocketAddress() + " has connected.");
                handleClient(socket);
            } catch (IOException e) {
                System.out.println("Error handling client " + e);
                e.printStackTrace();
                continue;
            }
        }
    }

    private static void handleClient(Socket socket) {
        executor.execute(new ClientHandler(socket));
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_20226_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
                close();
            }
        }

        @Override
        public void run() {
            try {
                String request;
                while ((request = in.readLine()) != null) {
                    handleRequest(request);
                }
            } catch (IOException e) {
                e.printStackTrace();
                close();
            }
        }

        private void handleRequest(String request) {
            // TODO: Handle request for security sensitive operations
            // e.g., check for SQL Injection, Cross-Site Scripting (XSS), etc.

            // For example, simple echo:
            out.println("Echo: " + request);
            out.flush();
        }

        private void close() {
            try {
                socket.close();
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}