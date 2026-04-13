import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14316_SocketServer_A07 {
    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Start a new thread to handle communication with the client
            new ClientHandler(socket).start();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_14316_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read a message from the client
            byte[] buffer = new byte[1024];
            int bytesRead = socket.getInputStream().read(buffer);
            String message = new String(buffer, 0, bytesRead);
            System.out.println("Received message: " + message);

            // Send a message back to the client
            String response = "Hello, client!";
            socket.getOutputStream().write(response.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}