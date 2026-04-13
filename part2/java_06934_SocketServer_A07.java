import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06934_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                // Handle the client connection here
                // For simplicity, we'll just close the connection after a few requests
                // If you want to handle connections, you should use a thread or a separate thread
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}