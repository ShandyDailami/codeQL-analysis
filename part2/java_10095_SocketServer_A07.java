import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10095_SocketServer_A07 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(4444)) {
            System.out.println("Server is listening on port 4444");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                AuthHandler handler = new AuthHandler(socket);
                handler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class AuthHandler extends Thread {
        private final Socket socket;
        private String username;
        private String password;

        public java_10095_SocketServer_A07(Socket socket) {
            this.socket = socket;
            this.username = "guest";
            this.password = "guest";
        }

        @Override
        public void run() {
            try {
                socket.getInputStream(); // Read the initial request
                socket.getOutputStream().write((username + ":" + password).getBytes()); // Send the authentication result
                socket.close(); // Close the socket
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}