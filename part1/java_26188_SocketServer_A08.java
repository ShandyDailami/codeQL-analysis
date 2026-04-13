import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26188_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Here you can create a new Thread for each client
                // Security concerns here would be about verifying the client's identity and ensuring their data is securely transferred
                // This is not included in this example
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}