import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33623_SocketServer_A08 {

    private static final int PORT = 4999;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

            // Start a new thread for each client
            new ClientHandler(socket).start();
        }
    }

    static class ClientHandler extends Thread {
        private final Socket socket;

        public java_33623_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Implement client-specific functionality here.
        }
    }
}