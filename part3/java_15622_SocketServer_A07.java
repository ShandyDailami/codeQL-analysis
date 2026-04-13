import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15622_SocketServer_A07 {

    private static final int PORT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Create new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;

        public java_15622_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            // Handle client communication here
        }
    }
}