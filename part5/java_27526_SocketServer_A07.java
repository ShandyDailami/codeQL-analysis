import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_27526_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");

                // Create a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Server could not start: " + e.getMessage());
       .
.
.
.
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_27526_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Handle the client connection here...
            // For now, just print out a message and close the socket
            System.out.println("Client connected");
            socket.close();
        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
        }
    }
}