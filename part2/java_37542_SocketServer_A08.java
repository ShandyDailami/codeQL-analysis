import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37542_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client is connected: " + socket.getRemoteSocketAddress());

                // Handle the client in a new thread
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket socket;

    public java_37542_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Receive a message from the client
            String message = new String(socket.getInputStream().readNBytes(1024));
            System.out.println("Received: " + message);

            // Send a response back to the client
            String response = "Server received your message: " + message;
            socket.getOutputStream().writeBytes(response.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}