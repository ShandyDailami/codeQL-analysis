import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_25847_SocketServer_A08 {
    private static ExecutorService executor;

    public static void main(String[] args) {
        int port = 1234;
        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            System.out.println("Server started at port " + port);

            executor = Executors.newFixedThreadPool(10);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Pass request to executor
                executor.execute(new RequestHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close executor and server
            executor.shutdown();
            try { server.close(); } catch (IOException e) { e.printStackTrace(); }
            System.out.println("Server stopped.");
        }
    }

    private static class RequestHandler implements Runnable {
        private Socket socket;

        public java_25847_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Here we are assuming the client will send a simple string message.
                // In a real application, you would probably use a BufferedReader to read the message,
                // check for integrity failures, and then send a response back.
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String message = reader.readLine();
                System.out.println("Received message: " + message);

                // For the sake of simplicity, we'll just respond with the same message back
                writer.writeBytes("Received: " + message + "\n");
                writer.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}