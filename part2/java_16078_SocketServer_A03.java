import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16078_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Create a new thread for each client connection
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to listen on port " + PORT);
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_16078_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Read from the client
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Received: " + message);

                // Send a response
                String response = "Hello, client!";
                byte[] responseBytes = response.getBytes();
                socket.getOutputStream().write(responseBytes);
            } catch (IOException e) {
                System.out.println("Failed to handle client connection");
                e.printStackTrace();
            }
        }
    }
}