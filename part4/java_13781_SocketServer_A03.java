import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13781_SocketServer_A03 {
    private static final int DEFAULT_PORT = 12345;

    public static void main(String[] args) {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client " + client.getInetAddress().getHostAddress() + " connected");

                // Handle client connection in a new thread
                new Thread(new ClientHandler(client)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket client;

        public java_13781_SocketServer_A03(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            // Handle client connection here using standard libraries only
            try {
                // Receive message from client
                byte[] buffer = new byte[1024];
                int bytesRead = client.getInputStream().read(buffer);
                String message = new String(buffer, 0, bytesRead);

                // Print received message
                System.out.println("Received message from client: " + message);

                // Send response back to client
                String response = "Server received your message: " + message;
                client.getOutputStream().write(response.getBytes());

                // Close connection
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}