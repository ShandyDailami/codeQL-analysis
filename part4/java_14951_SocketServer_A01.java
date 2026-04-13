import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14951_SocketServer_A01 {
    private static final int PORT = 4445;

    public static void main(String[] args) {
        // Create server socket and bind it to port
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                // Wait for client to connect
                Socket client = server.accept();
                System.out.println("Client connected: " + client.getRemoteSocketAddress());

                // Handle client connection in new thread
                new HandleClient(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class HandleClient extends Thread {
        private final Socket client;

        public java_14951_SocketServer_A01(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            // Handle client here, for example reading and sending data
            try {
                // Read from client
                byte[] buffer = new byte[1024];
                int bytesRead = client.getInputStream().read(buffer);
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Received: " + message);

                // Send response
                String response = "Hello, client!";
                byte[] responseBytes = response.getBytes();
                client.getOutputStream().write(responseBytes);
                client.getOutputStream().flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}