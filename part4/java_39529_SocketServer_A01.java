import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_39529_SocketServer_A01 {

    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {

        int port = 8080;
        ServerSocket server = new ServerSocket(port);

        System.out.println("Server is listening on port " + port);

        executor = Executors.newFixedThreadPool(10);

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected " + client.getRemoteSocketAddress());

            executor.execute(new HandleClient(client));
        }
    }

    static class HandleClient implements Runnable {
        private Socket client;

        public java_39529_SocketServer_A01(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                InputStream input = client.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String request = reader.readLine();
                System.out.println("Received: " + request);

                OutputStream output = client.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);

                writer.println("Hello, client!");
                writer.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}