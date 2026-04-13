import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11101_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080); // Create server socket on port 8080
            System.out.println("Server is listening on port 8080...");

            while (true) {
                Socket socket = serverSocket.accept(); // Accept a client socket
                System.out.println("A new client connected");

                // Handle client communication
                handleClientCommunication(socket);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClientCommunication(Socket socket) {
        // TODO: Implement client communication handling
    }
}