import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_24759_SocketServer_A07 {
    private static final String AUTH_USER = "user";
    private static final String AUTH_PASSWORD = "password";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server started on port 8080.");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected.");

                new Handler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection.");
            e.printStackTrace();
        }
    }

    private static class Handler extends Thread {
        private final Socket socket;

        public java_24759_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                if (authenticate()) {
                    // Handle incoming connections here
                } else {
                    socket.close();
                }
            } catch (IOException e) {
                System.out.println("Error handling client connection.");
                e.printStackTrace();
            }
        }

        private boolean authenticate() throws IOException {
            // Create a new reader for the socket input stream
            // Read the username and password from the socket and compare them
            return socket.getInputStream().readUTF().equals(AUTH_USER)
                    && socket.getInputStream().readUTF().equals(AUTH_PASSWORD);
        }
    }
}