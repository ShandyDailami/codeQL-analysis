import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34739_SocketServer_A07 {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is running on port: " + SERVER_PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getInetAddress() + " connected");

                handleRequest(socket);
            }
        } catch (IOException e) {
            System.out.println("Error while setting up the server: " + e.getMessage());
        }
    }

    private static void handleRequest(Socket socket) {
        try {
            // Receive request from client
            // Here we are not doing anything with it - you would normally receive and process data
            // For the purpose of this example, we'll just close the connection
            socket.close();
        } catch (IOException e) {
            System.out.println("Error while handling request: " + e.getMessage());
        }
    }
}