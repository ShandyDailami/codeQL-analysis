import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36915_SocketServer_A08 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");

                // Here we are going to make the server fail in a way that is considered integrity failure.
                // Specifically, we are going to drop the connection.
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}