import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30320_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started at port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                // Handle integrity failure for this specific client
                // ...

                // Close the socket here
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}