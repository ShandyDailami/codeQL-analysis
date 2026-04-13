import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40139_SocketServer_A08 {

    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // Here you can implement your own security measures related to A08_IntegrityFailure
            // For simplicity, this example disables SSL for the socket
            socket.setEnabledSSL(false);

            // Handle the client connection here

            // ...

            socket.close();
        }
    }
}