import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07013_SocketServer_A01 {

    private static final int PORT = 1234;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("Connected to " + client.getRemoteSocketAddress());

                // Handle the client connection in a new thread
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Private inner class for handling individual client connections
    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_07013_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            // Handle communication with the client here
        }
    }
}