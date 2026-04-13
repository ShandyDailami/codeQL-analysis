import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33989_SocketServer_A03 {

    private static final int PORT = 9001;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Perform security-sensitive operations related to injection
                new Thread(new ClientHandler(socket)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_33989_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Perform operations with socket here
            // This is just a placeholder, please implement the real logic
        }
    }
}