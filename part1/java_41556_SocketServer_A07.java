import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41556_SocketServer_A07 {
    public static void main(String[] args) {
        int port = 5000; // choose a port
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is running on port " + port);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("A new client is connected : " + clientSocket.getRemoteSocketAddress());

                // Handle the client connection here

                // Close the client socket
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}