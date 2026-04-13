import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_35815_SocketServer_A03 {
    private static final int PORT = 4445; // Fixed port for testing purposes

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Handle client connection in a separate thread
                new Thread(new SocketHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SocketHandler implements Runnable {
        private Socket socket;

        public java_35815_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle client connection here
            // ...
        }
    }
}