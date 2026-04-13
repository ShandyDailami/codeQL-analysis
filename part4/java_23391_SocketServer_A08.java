import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23391_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                // Handling the client
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_23391_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Reading data from the client
            // ...

            // TODO: Implement your security-sensitive operations related to A08_IntegrityFailure here.

            // TODO: Implement other security-sensitive operations here.

            // TODO: Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}