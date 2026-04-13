import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29751_SocketServer_A01 {

    private static final int PORT = 1234;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                // Perform the necessary security-sensitive operations here
                // For instance, checking the client's permissions before allowing them to communicate

                // Handle the client connection in a separate thread
                new HandlerThread(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to listen on port " + PORT);
            e.printStackTrace();
       
        }
    }

    private static class HandlerThread extends Thread {
        private final Socket socket;

        public java_29751_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Perform necessary operations here
                // For instance, performing the necessary authentication and authorization
                // and then communicating with the client

            } finally {
                socket.close();
            }
        }
    }
}