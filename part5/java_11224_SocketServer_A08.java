import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_11224_SocketServer_A08 {
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newFixedThreadPool(5);
        ServerSocket server = new ServerSocket(8000);
        while (true) {
            Socket clientSocket = server.accept();
            System.out.println("Client connected!");
            executor.execute(new ClientHandler(clientSocket));
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_11224_SocketServer_A08(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String request;
                while ((request = in.readLine()) != null) {
                    System.out.println("Received request: " + request);
                    if (!isSecureRequest(request)) {
                        out.println("Error: Requested resource is not secure.");
                        out.flush();
                        clientSocket.close();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean isSecureRequest(String request) {
            // Implementation of the secure operation.
            // For this example, we'll assume any request that starts with "Secure"
            // is secure. In reality, you'd want to use a more sophisticated
            // method of verifying the integrity of the request.
            return request.startsWith("Secure");
        }
    }
}