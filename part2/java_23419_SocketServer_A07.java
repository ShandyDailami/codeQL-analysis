import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23419_SocketServer_A07 {
    private static final int SERVER_PORT = 9000;

    public static void main(String[] args) {
        System.out.println("Server is starting...");

        // Step 1: Create a ServerSocket
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is listening on port: " + SERVER_PORT);

            while (true) {
                // Step 2: Accept a client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("A client has connected!");

                // Step 3: Handle the client connection
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandler.start();
            }
        } catch (IOException e) {
            System.out.println("Server could not start due to: " + e.getMessage());
            e.printStackTrace();
        }
    }
}