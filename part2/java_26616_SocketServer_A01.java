import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_26616_SocketServer_A01 {
    private static ExecutorService executor;
    private static int port = 8080;

    public static void main(String[] args) throws IOException {
        // Step 1: Initialize executor service
        executor = Executors.newFixedThreadPool(10);

        // Step 2: Start listening for client connections
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server listening on port " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Step 3: Initialize new threads for communication
            executor.execute(new SocketHandler(socket));
        }
    }

    private static class SocketHandler implements Runnable {
        private Socket socket;

        public java_26616_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                // Step 4: Communicate with client
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                String input;
                while ((input = in.readLine()) != null) {
                    System.out.println("Received: " + input);
                    out.println("Hello, " + input);
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}