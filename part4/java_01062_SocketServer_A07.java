import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_01062_SocketServer_A07 {
    private static ExecutorService executor;
    private static ServerSocket server;

    public static void main(String[] args) throws IOException, InterruptedException {
        executor = Executors.newCachedThreadPool();
        server = new ServerSocket(8189);
        System.out.println("Server is listening on port 8189");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected: " + client.getRemoteSocketAddress());
            handleClient(client);
        }
    }

    private static void handleClient(Socket client) {
        executor.execute(new ClientHandler(client));
    }

    private static class ClientHandler implements Runnable {
        private Socket client;

        public java_01062_SocketServer_A07(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                 PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {

                String request;
                while ((request = in.readLine()) != null) {
                    if ("auth".equals(request)) { // simulate A07_AuthFailure
                        out.println("Authentication failed. Please try again.");
                        out.flush();
                        return;
                    }

                    // Otherwise, simply echo back the request
                    out.println("Received: " + request);
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}