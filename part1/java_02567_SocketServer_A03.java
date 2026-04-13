import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_02567_SocketServer_A03 {

    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        executor = Executors.newFixedThreadPool(5);

        while (true) {
            Socket client = server.accept();
            System.out.println("New client accepted: " + client.getRemoteSocketAddress());

            executor.execute(new ClientHandler(client));
        }
    }

    private static class ClientHandler implements Runnable {

        private Socket client;

        public java_02567_SocketServer_A03(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try (InputStream in = client.getInputStream();
                 OutputStream out = client.getOutputStream()) {

                byte[] buffer = new byte[1024];
                int bytesRead;
                String data;

                while ((bytesRead = in.read(buffer)) != -1) {
                    data = new String(buffer, 0, bytesRead);

                    // Check for SQL Injection attack here
                    if (isSqlInjectionAttack(data)) {
                        out.write("Error: Detected SQL Injection attack.\n".getBytes());
                        return;
                    }

                    out.write(("Got: " + data + "\n").getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean isSqlInjectionAttack(String data) {
            // Implement your own SQL Injection detection mechanism here
            return data.contains(";") || data.contains("--");
        }
    }
}