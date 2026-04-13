import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_24132_SocketServer_A01 {
    private static final String PASSWORD = "secure";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client " + socket.getRemoteSocketAddress() + " has connected");

                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Server could not start: " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private String username;
        private String password;

        public java_24132_SocketServer_A01(Socket socket) {
            this.socket = socket;
            this.username = socket.getRemoteSocketAddress().toString();
            this.password = new String(socket.getInputStream().readNBytes(socket.getInputStream().available()));
        }

        @Override
        public void run() {
            try {
                if (!authenticate()) {
                    socket.close();
                    return;
                }

                handleRequest(socket.getInputStream(), socket.getOutputStream());
            } catch (IOException e) {
                System.err.println("Error handling client " + socket.getRemoteSocketAddress() + ": " + e.getMessage());
            }
        }

        private boolean authenticate() {
            return PASSWORD.equals(password);
        }

        private void handleRequest(InputStream input, OutputStream output) throws IOException {
            // TODO: Handle request using input and output streams
        }
    }
}