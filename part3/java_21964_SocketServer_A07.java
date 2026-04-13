import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21964_SocketServer_A07 {

    private static final int PORT = 4445;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started. Listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Handle the client connection here

                // Close the socket connection
                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}