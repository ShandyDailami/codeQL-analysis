import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11181_SocketServer_A03 {
    private static final int PORT = 6000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");

            // Creating a new thread for each client
            new Thread(() -> {
                // handle each client here...
            }).start();
        }
    }
}