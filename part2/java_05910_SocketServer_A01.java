import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_05910_SocketServer_A01 {

    private static ExecutorService exec = Executors.newFixedThreadPool(10);
    private static ServerSocket server;

    public static void main(String[] args) {
        int port = 8080;
        try {
            server = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());
                exec.execute(new ClientHandler(client));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            server.close();
            exec.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket client;

        public java_05910_SocketServer_A01(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                // Create input and output streams
                InputStream in = client.getInputStream();
                OutputStream out = client.getOutputStream();

                // Read and write the data
                byte[] buffer = new byte[1024];
                int length;
                while ((length = in.read(buffer)) != -1) {
                    out.write(buffer, 0, length);
                }

                // Close the connection
                client.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}