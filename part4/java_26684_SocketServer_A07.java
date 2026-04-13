import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26684_SocketServer_A07 {

    private static final int PORT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                // Handling the client in a separate thread
                Thread thread = new Thread(new SocketHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection: " + e.getMessage());
            e.printStackTrace();
        }
    }

    static class SocketHandler implements Runnable {
        private Socket socket;

        public java_26684_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Implement authentication and communication logic
            // You can use standard libraries and security-sensitive operations related to A07_AuthFailure
        }
    }
}