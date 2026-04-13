import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36470_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345, 0, InetAddress.getByName("localhost"));
            System.out.println("Server started on port 12345");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Secure operations related to A01_BrokenAccessControl
                // For example, disallow access to the server socket
                serverSocket.setReuseAddress(true);

                // Create a new thread for handling each client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_36470_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle client's request, e.g., read from socket and send a response
        }
    }
}