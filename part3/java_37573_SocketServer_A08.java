import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37573_SocketServer_A08 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                // Handle the client connection in a separate thread
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to listen on port " + PORT);
            System.exit(-1);
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_37573_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle client requests and responses here
            // This is a placeholder for future implementation
            try {
                // Read client request
                // ...

                // Send response back to client
                // ...
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}