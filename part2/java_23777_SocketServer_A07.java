import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23777_SocketServer_A07 {

    private static final int PORT = 9999;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create server socket and bind it to port
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            // Accept connection from client
            socket = serverSocket.accept();
            System.out.println("Client connected");

            // Handle client connection and perform operations
            handleClient(socket);

        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            // Close the connection
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void handleClient(Socket socket) {
        // TODO: Implement authentication-related operations
    }
}