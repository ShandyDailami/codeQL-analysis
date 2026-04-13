import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36806_SocketServer_A01 {

    private static final int PORT = 4445;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client " + socket.getRemoteSocketAddress() + " connected");

                // Start a new thread for handling each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
            e.printStackTrace();
       
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_36806_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client communication here
        // For example, you can read the client's input and send it back to the client
        // For security sensitive operations, consider using SSL/TLS for communication

        // TODO: Implement security sensitive operations related to A01_BrokenAccessControl
    }
}