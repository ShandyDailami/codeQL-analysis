import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37484_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = server.accept();
                System.out.println("Accepted new connection from: " + socket.getRemoteSocketAddress());

                new ServerThread(socket).start();
            }
        } catch (IOException e) {
            System.err.println("IO exception occurred: " + e.getMessage());
        }
    }

    private static class ServerThread extends Thread {
        private final Socket socket;

        public java_37484_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Your server-side logic goes here
            // e.g., use SSL for data encryption and authentication
            // Use try-with-resources to close the socket
        }
    }
}