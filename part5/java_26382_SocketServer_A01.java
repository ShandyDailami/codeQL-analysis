import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26382_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Start a new thread for the client to handle communication
            new ClientHandler(socket).start();
        }
    }

    // This is a simple class for handling communication with a client
    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_26382_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Here you can handle the client communication
            // For now, we just close the socket
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}