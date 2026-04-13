import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30754_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9090);
            System.out.println("Server started. Waiting for client connection...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

                // Start a new thread for handling the client request
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to bind port 9090. Server will close.");
            System.exit(-1);
        }
    }
}