import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_08744_SocketServer_A01 {
    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(10);

        try (ServerSocket server = new ServerSocket(8080)) {
            while (true) {
                try {
                    Socket socket = server.accept();
                    System.out.println("Client connected");
                    executor.execute(new ClientHandler(socket));
                } catch (Exception ex) {
                    System.out.println("Error handling client " + ex);
                }
            }
        } catch (IOException ex) {
            System.out.println("Error listening on port 8080 " + ex);
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_08744_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                String request;
                while ((request = in.readLine()) != null) {
                    System.out.println("Received: " + request);
                    // Perform security-sensitive operations, e.g., check request for broken access control
                    if (request.equals("BROKEN_ACCESS_CONTROL")) {
                        out.println("Broken access control detected, sorry!");
                        return;
                    }
                    out.println("Processed request: " + request);
                }
            } catch (IOException ex) {
                System.out.println("Error processing client " + ex);
            }
        }
    }
}