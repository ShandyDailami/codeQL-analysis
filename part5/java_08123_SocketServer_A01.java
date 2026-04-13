import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08123_SocketServer_A01 {
    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        // create a server socket
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        // continuously listen for client connections
        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected: " + client.getRemoteSocketAddress());

            // create a new thread for each connection
            new Thread(new SocketServerHandler(client)).start();
        }
    }
}

class SocketServerHandler implements Runnable {
    private final Socket client;

    public java_08123_SocketServer_A01(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        // handle the client connection, e.g., read from and write to the client
        // ...
    }
}