import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_23063_SocketServer_A01 {
    private static ExecutorService executor = Executors.newCachedThreadPool();
    private static ServerSocket server = null;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(6000); // Binding to port 6000
            System.out.println("Server started at " + server.getLocalSocketAddress());
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());
                // Handling the client in a new thread
                executor.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_23063_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Reading the request from the client
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String request = reader.readLine();

                // Simple XSS attack
                String response = "<p>Your input: <b>" + request + "</b></p>";

                // Writing the response back to the client
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println("HTTP/1.1 200 OK");
                writer.println("Content-Type: text/html");
                writer.println("Content-Length: " + response.length());
                writer.println();
                writer.println(response);
                writer.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}