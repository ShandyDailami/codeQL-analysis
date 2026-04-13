import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33261_SocketServer_A01 {

    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(PORT);

        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // TODO: Add code here to handle client connections securely and appropriately
            // For example, you can use SSL/TLS to encrypt the data sent between the server and the client
            // and check the client's IP address against a list of known good IPs

            // Close the socket and handle the connection here
            socket.close();
        }
    }
}