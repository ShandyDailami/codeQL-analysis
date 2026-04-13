import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25591_SocketServer_A07 {
    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        // Create a server socket and listen on the specified port
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started. Waiting for client connections...");

        while (true) {
            // Accept a client connection
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // Create a new thread to handle communication with the client
            new ClientHandler(socket).start();
       
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_25591_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client communication here...
    }
}