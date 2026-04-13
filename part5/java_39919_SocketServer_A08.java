import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39919_SocketServer_A08 {

    private int port;

    public java_39919_SocketServer_A08(int port) {
        this.port = port;
    }

    public void start() {
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Start a new thread to handle the client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to start server on port " + port);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SocketServer(8080).start();
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_39919_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Read the incoming message
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                if (bytesRead < 0) {
                    System.out.println("Client disconnected");
                    return;
                }

                // Process the message
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Received: " + message);

                // Send a response
                String response = "Hello, client!";
                socket.getOutputStream().write(response.getBytes());
            } catch (IOException e) {
                System.out.println("Failed to handle client");
                e.printStackTrace();
            }
        }
    }
}