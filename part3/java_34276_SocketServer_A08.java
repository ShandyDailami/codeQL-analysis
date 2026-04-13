import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34276_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // You can add more code here to handle the client if needed.
                // For now, we'll just close the connection.
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}