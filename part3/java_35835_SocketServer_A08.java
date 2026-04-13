import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_35835_SocketServer_A08 {

    private static final int PORT = 9999;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                Handler handler = new Handler(socket);
                Thread thread = new Thread(handler);
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while listening for client connection. " + e.getMessage());
        }
    }

    private static class Handler implements Runnable {
        private Socket socket;

        public java_35835_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Implement your security-sensitive operations related to A08_IntegrityFailure
            // You can use standard Java libraries here.
        }
    }
}