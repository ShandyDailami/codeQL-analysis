import java.net.ServerSocket;
import java.net.Socket;

public class java_21231_SocketServer_A07 {

    public static void main(String[] args) {
        try {
            // Create a ServerSocket
            ServerSocket serverSocket = new ServerSocket(12345);

            System.out.println("Waiting for client...");

            // Accept client connection
            Socket socket = serverSocket.accept();

            System.out.println("Client connected");

            // Handle client connection here

            // Close the socket
            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}