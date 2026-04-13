import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14376_SocketServer_A07 {

    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 8080;
    private static final String AUTHENTICATION_SUCCESS = "Authentication Successful!";
    private static final String AUTHENTICATION_FAILURE = "Authentication Failed!";

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is running on port " + SERVER_PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                new Thread(new SocketHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class SocketHandler implements Runnable {
        private final Socket socket;

        public java_14376_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Authentication process here
                // For simplicity, let's just assume we are authenticated
                if (authenticate()) {
                    socket.getOutputStream().write(AUTHENTICATION_SUCCESS.getBytes());
                } else {
                    socket.getOutputStream().write(AUTHENTICATION_FAILURE.getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean authenticate() {
            // Implementation of authentication logic here
            // For simplicity, let's just assume we are authenticated
            return true;
        }
    }
}