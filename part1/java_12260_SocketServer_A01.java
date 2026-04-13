import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12260_SocketServer_A01 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred when trying to listen on port " + PORT);
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_12260_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Perform secure operations related to A01_BrokenAccessControl
                // e.g., perform encryption, decryption, or authentication

                // Handle client socket operations
                // ...

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}