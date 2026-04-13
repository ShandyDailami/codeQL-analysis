import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14465_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        int port = 5000;

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Perform security-sensitive operations related to A07_AuthFailure here
                // e.g., check if the client is authenticated, or handle any errors that might occur during the authentication process

                // Create a new thread for each client connection
                new ClientHandler(socket).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }
}