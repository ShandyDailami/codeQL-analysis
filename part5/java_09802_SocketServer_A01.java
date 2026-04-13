import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09802_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Handle the client connection in a separate thread
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while trying to listen on port " + PORT);
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_09802_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Add code here to handle client communication
            // For now, let's just print out the client's IP address
            System.out.println("Client IP: " + socket.getInetAddress().getHostAddress());
        }
    }
}