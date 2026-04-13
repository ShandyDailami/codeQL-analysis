import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_28351_SocketServer_A08 {

    private static ExecutorService executor;
    private static ServerSocket server;

    public static void main(String[] args) throws IOException {
        startServer(6666);

        // This will keep the main thread from exit
        while (true) {
            Thread thread = new Thread(new ClientHandler());
            thread.start();
        }
    }

    public static void startServer(int port) throws IOException {
        server = new ServerSocket(port);
        executor = Executors.newCachedThreadPool();
        System.out.println("Server is listening on port " + port);
    }

    public static class ClientHandler implements Runnable {

        private Socket client;
        private BufferedReader in;
        private PrintWriter out;

        @Override
        public void run() {
            try {
                client = server.accept();
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out = new PrintWriter(client.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                }

                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}