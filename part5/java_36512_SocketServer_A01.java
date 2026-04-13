import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36512_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started at port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Create a new thread to handle the client request
            new ClientHandler(socket).start();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_36512_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO: Handle the client request here
    }
}