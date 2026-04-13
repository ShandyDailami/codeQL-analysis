import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_41860_SocketServer_A08 {

    private static final int PORT = 8080;
    private static ExecutorService executorService;

    public static void main(String[] args) throws IOException {
        executorService = Executors.newFixedThreadPool(10);
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());
            HandlerSocket handler = new HandlerSocket(socket, executorService);
            handler.start();
        }
    }

    static class HandlerSocket extends Thread {
        private Socket socket;
        private ExecutorService executor;

        public java_41860_SocketServer_A08(Socket socket, ExecutorService executor) {
            this.socket = socket;
            this.executor = executor;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                while (true) {
                    String message = in.readLine();
                    if (message == null) {
                        socket.close();
                        System.out.println("Connection closed by client");
                        return;
                    }
                    System.out.println("Received: " + message);

                    String response = processMessage(message);
                    out.write(response.getBytes());
                    out.newLine();
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String processMessage(String message) {
            // Add security-sensitive operations here
            // For example, we can use message as a key to generate a secure hash
            // and compare it to a stored hash for verification.
            // In a real-world scenario, this would be replaced with a secure hash
            // generation and verification method.
            return "Secure Message Processed: " + message;
        }
    }
}