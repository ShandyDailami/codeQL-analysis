import java.net.ServerSocket;
import java.net.Socket;

public class java_01640_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Sending a response to the client
            String response = "Hello, client!\n";
            socket.getOutputStream().write(response.getBytes());
        }
    }
}