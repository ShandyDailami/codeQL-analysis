import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14243_SocketServer_A01 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                // Handle the client here
                // For example, we're just simply closing the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}