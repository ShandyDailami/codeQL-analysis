import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09079_SocketServer_A08 {

    private static final int PORT = 9000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // handle the client in a new thread
            new ClientHandler(socket).start();
        }
    }

    private static class ClientHandler extends Thread {

        private Socket socket;

        public java_09079_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: handle the client in a secure way
            try {
                // here you can implement a security-sensitive operation
                // e.g., integrity check
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}