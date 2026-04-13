import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40686_SocketServer_A07 {

    private static final int SERVER_PORT = 1234;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Send welcome message to client
                clientSocket.getOutputStream().write("Welcome to the server!\n".getBytes());

                // Close connection
                clientSocket.close();
           
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}