import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23748_SocketServer_A07 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Perform authentication here
                // If authentication fails, close the connection
                if (!authenticate(socket)) {
                    System.out.println("Authentication failed, closing connection: " + socket.getRemoteSocketAddress());
                    socket.close();
                    continue;
                }

                // Handle the connection in a separate thread
                new Handler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Server failed to listen on port " + PORT);
            e.printStackTrace();
        }
    }

    private static boolean authenticate(Socket socket) {
        // Implement authentication logic here
        // For now, just return true
        return true;
    }

    private static class Handler extends Thread {
        private Socket socket;

        public java_23748_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle the communication here
        }
    }
}