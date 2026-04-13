import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31719_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            // Creating a server socket on port 1234
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server is waiting for a client connection...");

            // Accepting the client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Closing the server socket
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}