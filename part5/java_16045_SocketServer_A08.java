import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16045_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Here you can start processing the received data

                // Close the socket after processing
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}