import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26072_SocketServer_A03 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Step 1: Create a ServerSocket on port 12345
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            // Step 2: Accept a connection from the client
            socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

            // Step 3: Handle the request from the client
            // Here, we are just closing the socket to simulate a security-sensitive operation
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Step 4: Close the resources
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}