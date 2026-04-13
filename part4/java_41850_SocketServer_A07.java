import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41850_SocketServer_A07 {
    private static final String SERVER_MESSAGE = "Welcome to the server!";
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Send welcome message to client
                sendMessage(socket, SERVER_MESSAGE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendMessage(Socket socket, String message) {
        try {
            socket.getOutputStream().write(message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}