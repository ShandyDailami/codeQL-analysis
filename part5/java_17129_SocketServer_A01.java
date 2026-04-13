import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17129_SocketServer_A01 {

    private static final int PORT = 5000;

    public static void main(String[] args) {
        System.out.println("Server is starting...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                System.out.println("Waiting for a connection...");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Close the socket immediately after a client has connected
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Server has shut down.");
    }
}