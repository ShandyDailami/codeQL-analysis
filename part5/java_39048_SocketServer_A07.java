import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39048_SocketServer_A07 {
    private static final String AUTHENTICATION_SUCCESS = "Authentication successful!";
    private static final String AUTHENTICATION_FAILURE = "Authentication failed!";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            while (true) {
                Socket socket = server.accept();
                new EchoHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to bind to port 8080: " + e);
            System.exit(1);
        }
    }

    private static class EchoHandler extends Thread {
        private final Socket socket;

        public java_39048_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Authentication logic goes here. This is a simple example.
                if (authenticateUser(socket)) {
                    new EchoSession(socket).start();
                } else {
                    sendResponse(socket, AUTHENTICATION_FAILURE);
                }
            } catch (IOException e) {
                System.err.println("Error handling connection from " + socket + ": " + e);
            }
        }

        private void sendResponse(Socket socket, String message) throws IOException {
            socket.getOutputStream().write(message.getBytes());
        }

        private boolean authenticateUser(Socket socket) throws IOException {
            // Implementation of user authentication logic goes here. This is a simple example.
            return true; // for simplicity, always return true
        }
    }

    private static class EchoSession extends Thread {
        private final Socket socket;

        public java_39048_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (socket.getInputStream())) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = socket.getInputStream().read(buffer)) != -1) {
                    String echoMessage = new String(buffer, 0, bytesRead);
                    sendResponse(socket, echoMessage);
                }
            } catch (IOException e) {
                System.err.println("Error reading from connection from " + socket + ": " + e);
            }
        }

        private void sendResponse(Socket socket, String message) throws IOException {
            socket.getOutputStream().write(message.getBytes());
        }
    }
}