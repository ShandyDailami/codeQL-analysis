import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_12012_SocketServer_A01 {
    private static ExecutorService executor;
    private static ServerSocket server;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();
        server = new ServerSocket(12345);

        System.out.println("Server is running on port 12345");

        while (true) {
            try {
                Socket client = server.accept();
                System.out.println("Accepted a new connection from " + client.getRemoteSocketAddress());
                Handler handler = new Handler(client);
                executor.execute(handler);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private static class Handler extends Thread {
        private Socket client;

        public java_12012_SocketServer_A01(Socket client) {
            this.client = client;
        }

        public void run() {
            try {
                InputStream input = client.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // For demonstration purposes, we will respond with the same message back to the client.
                    PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                    writer.println(message);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}