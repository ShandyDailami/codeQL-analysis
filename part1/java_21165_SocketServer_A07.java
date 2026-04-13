import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21165_SocketServer_A07 {

    private static final String SERVER_MESSAGE = "Server: Hello Client!";
    private static final int PORT = 6789;

    public static void main(String[] args) {
        System.out.println("Server started. Listening on port: " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection: " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_21165_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (socket) {
                byte[] buffer = new byte[1024];
                int bytesRead;

                while ((bytesRead = socket.getInputStream().read(buffer)) != -1) {
                    String message = new String(buffer, 0, bytesRead);
                    System.out.println("Client says: " + message);

                    if ("exit".equals(message)) {
                        System.out.println("Client disconnected.");
                        return;
                    }

                    socket.getOutputStream().write(SERVER_MESSAGE.getBytes());
                    socket.getOutputStream().flush();
                }
            } catch (IOException e) {
                System.out.println("Error handling client: " + e.getMessage());
            }
        }
    }
}