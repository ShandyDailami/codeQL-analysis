import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39962_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Create a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Handles client requests
    static class ClientHandler extends Thread {
        private Socket socket;

        public java_39962_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: handle client requests
        }
    }
}