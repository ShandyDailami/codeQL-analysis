import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_20974_SocketServer_A03 {

    private static ExecutorService executorService;

    public static void main(String[] args) throws IOException {
        executorService = Executors.newFixedThreadPool(10);

        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started on port 8000");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New connection accepted from " + clientSocket.getRemoteSocketAddress());

            executorService.execute(new SocketHandler(clientSocket));
        }
    }

    static class SocketHandler implements Runnable {
        private final Socket socket;

        public java_20974_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String request = reader.readLine();
                System.out.println("Request received: " + request);

                // TODO: Implement security-sensitive operations related to injection
                // For example, use a prepared statement to avoid SQL Injection

                // For simplicity, we assume no injection is happening
                String response = "Server response: " + request;
                writer.write(response.getBytes());

            } catch (IOException e) {
                System.out.println("Error handling client: " + e.getMessage());
            }
        }
    }
}