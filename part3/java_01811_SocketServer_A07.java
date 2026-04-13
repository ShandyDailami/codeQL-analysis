import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01811_SocketServer_A07 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // TODO: Implement authentication mechanism here
                // For simplicity, we'll just check if the client's IP address is allowed to connect
                String clientIP = socket.getRemoteSocketAddress().toString();
                if (isAllowedIP(clientIP)) {
                    new ClientHandler(socket).start();
                } else {
                    System.out.println("Authentication failed for client " + clientIP);
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // TODO: Implement a method to check if an IP address is allowed
    private static boolean isAllowedIP(String ip) {
        // This is a placeholder implementation and will not work in a production environment
        // For a real-world application, you'd want to use a more sophisticated method for checking IP addresses
        return true;
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_01811_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Handle client communication here
            // For simplicity, we'll just read a message from the client and echo it back
            try (socket.getInputStream(); socket.getOutputStream()) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = socket.getInputStream().read(buffer)) != -1) {
                    socket.getOutputStream().write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}