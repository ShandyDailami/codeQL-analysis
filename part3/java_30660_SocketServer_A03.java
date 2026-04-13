import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30660_SocketServer_A03 {
    private static final int PORT = 4000;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client " + socket.getRemoteSocketAddress() + " connected");

            // Handle client communication in a separate thread
            new ClientHandler(socket).start();
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;

        public java_30660_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Code to handle client communication
        }
    }
}