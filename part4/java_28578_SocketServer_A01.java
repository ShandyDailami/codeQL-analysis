import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28578_SocketServer_A01 {

    private static final int PORT = 6000;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());
            new ClientHandler(socket).start();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_28578_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                // handle client's request here
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}