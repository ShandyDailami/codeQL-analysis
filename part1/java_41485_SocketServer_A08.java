import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41485_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client " + socket.getInetAddress() + " connected");

                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection: " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_41485_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO: Handle client connection and security-sensitive operations related to A08_IntegrityFailure
    }
}