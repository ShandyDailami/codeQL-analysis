import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32653_SocketServer_A03 {
    private static final int SERVER_PORT = 1234;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Server is listening on port: " + SERVER_PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected");

            // Here you can start handling the client's request.
            // For instance, we'll just print out the remote host's IP address.
            System.out.println("Remote host address: " + socket.getRemoteSocketAddress().toString());

            // Close the socket to indicate that the client is now disconnected.
            socket.close();
        }
    }
}