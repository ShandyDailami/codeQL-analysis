import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20099_SocketServer_A08 {

    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Here, we will add the code for handling the secure socket connection
            // This part will be more complex and may require a secure implementation

            // Here, we will close the socket and handle other tasks
            socket.close();
        }
    }
}