import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_37740_SocketServer_A03 {
    private static ExecutorService executor;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server is running on port 5000");

        executor = Executors.newFixedThreadPool(10);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());
            executor.execute(new ClientHandler(socket));
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_37740_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String message = reader.readLine();
                System.out.println("Received: " + message);

                // Here we use a simplified method for demonstration purposes.
                // In a real-world scenario, you would want to avoid the use of InputStreams in this way.
                // This is just for demonstration purposes.
                String response = processInput(message);
                OutputStream output = socket.getOutputStream();
                output.write(response.getBytes());
                output.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private String processInput(String input) {
            // This method is a placeholder and is not secure.
            // In a real-world scenario, you would want to avoid the use of String manipulation in this way.
            // This is just for demonstration purposes.
            return "Server received: " + input;
        }
    }
}