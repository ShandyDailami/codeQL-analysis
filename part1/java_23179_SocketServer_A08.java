import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23179_SocketServer_A08 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Handle the client connection here
                // This is just a placeholder, actual implementation would involve handling multiple clients
                new Handler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while trying to listen on port " + PORT);
            e.printStackTrace();
        }
    }
}