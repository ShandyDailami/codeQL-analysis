import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_02069_SocketServer_A03 {

    private static ExecutorService executor;
    private static ServerSocket server;

    public static void main(String[] args) throws IOException, InterruptedException {

        executor = Executors.newCachedThreadPool();
        server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected from " + client.getRemoteSocketAddress());
            executor.execute(new ClientHandler(client));
        }
    }

    static class ClientHandler implements Runnable {

        private Socket client;

        public java_02069_SocketServer_A03(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Simple code to inject SQL or other code injection points.
                    if (message.contains("drop table")) {
                        writer.println("You've been injected, SQL code execution denied!");
                    } else {
                        writer.println("You've been injected, you can send whatever message you want!");
                    }
                }

                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}