import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19284_SocketServer_A03 {

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server started on port " + SERVER_PORT + "...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New connection from " + socket.getRemoteSocketAddress());

                // Create new thread for each client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_19284_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle client communication here
            // ...
        }
    }
}