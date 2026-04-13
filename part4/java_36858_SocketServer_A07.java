import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36858_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Handle client connection
            new ClientHandler(socket).start();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_36858_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read from client
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);

            // TODO: Add authentication here (e.g. using a password, hashing, etc.)

            // TODO: Process the received data (e.g. print it)

            // TODO: Send a response back to the client (e.g. OK)
            socket.getOutputStream().write("OK".getBytes());

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}