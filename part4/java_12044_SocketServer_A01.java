import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12044_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Send a message back to the client
            socket.getOutputStream().write("Hello, Client!\n".getBytes());
            socket.getOutputStream().flush();
       
            // Close the socket after communication
            socket.close();
        }
    }
}