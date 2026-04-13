import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33389_SocketServer_A03 {

    private static final int PORT = 4445;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started at port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Create a new thread to handle the client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler extends Thread {
        Socket socket;

        public java_33389_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Here, you would handle the client's communication with the server.
                // For example, you could read from the client, send back a response, or handle any security-sensitive operations.
                // However, for the purpose of this example, we're not doing any security-sensitive operations.

                // Just print out the client's IP address
                System.out.println("Handling client: " + socket.getRemoteSocketAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}