import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_24851_SocketServer_A01 {
    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Handle the client connection in a new thread
            new ClientHandler(socket).start();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_24851_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Implement secure client handling here
            // You can use SSL/TLS to secure the communication
            // You can also implement authentication and authorization

            // For now, we will just close the connection
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}