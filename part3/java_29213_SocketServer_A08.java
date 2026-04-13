import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_29213_SocketServer_A08 {

    private static ExecutorService executor;
    private static ServerSocket server;

    public static void main(String[] args) {
        // Create a new server socket
        try {
            server = new ServerSocket(8080);
            System.out.println("Server started on port 8080");
            executor = Executors.newFixedThreadPool(10);
            while (true) {
                handleConnection(server.accept());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void handleConnection(Socket socket) {
        executor.execute(new ClientHandler(socket));
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_29213_SocketServer_A08(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String request;
            try {
                while ((request = in.readLine()) != null) {
                    // TODO: Implement security-sensitive operations
                    // For instance, you might want to verify the integrity of the client
                    // Here you could use SSL/TLS for secure communication and validate the client's identity
                    // You also need to handle the request as per your application's requirements

                    // For simplicity, we'll just echo back the request
                    out.println(request);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeConnection();
            }
        }

        private void closeConnection() {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}