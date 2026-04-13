import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03510_SocketServer_A01 {

    private static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        // Create a new ServerSocket
        ServerSocket serverSocket = new ServerSocket(PORT, 0, InetAddress.getByName("localhost"));

        System.out.println("Waiting for client connection...");

        // Accept a client socket
        Socket socket = serverSocket.accept();

        System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

        // Close the server socket
        serverSocket.close();
    }
}