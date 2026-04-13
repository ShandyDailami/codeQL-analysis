import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13017_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Handler extends Thread {
        private final Socket socket;

        public java_13017_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle incoming connection
            // For simplicity, we'll just print a message and close the connection
            System.out.println("Handling connection from " + socket.getRemoteSocketAddress());
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}