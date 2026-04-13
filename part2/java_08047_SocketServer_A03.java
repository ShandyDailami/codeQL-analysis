import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_08047_SocketServer_A03 {
    private final int port;
    private final ExecutorService executor;

    public java_08047_SocketServer_A03(int port) {
        this.port = port;
        this.executor = Executors.newFixedThreadPool(10);
    }

    public void start() throws IOException {
        ServerSocket server = new ServerSocket(port);
        while (true) {
            Socket client = server.accept();
            executor.execute(new ClientHandler(client));
        }
    }

    private class ClientHandler implements Runnable {
        private final Socket client;

        public java_08047_SocketServer_A03(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try (InputStream in = client.getInputStream(); OutputStream out = client.getOutputStream()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                DataOutputStream writer = new DataOutputStream(out);

                String request = reader.readLine();
                // Handle request here and potentially perform injection
                // This is a simplistic example and may not be secure
                String response = "Server received: " + request;

                writer.write(response.getBytes());
            } catch (IOException e) {
                // Handle exception appropriately
            }
        }
    }
}