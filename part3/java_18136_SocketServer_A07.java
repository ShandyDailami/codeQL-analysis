import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18136_SocketServer_A07 {

    public static void main(String[] args) {
        try {
            // Create a ServerSocket and bind it to port 12345
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345");

            while (true) {
                // Accept a client connection
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Handle the client connection here
                // For now, just close the socket
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}