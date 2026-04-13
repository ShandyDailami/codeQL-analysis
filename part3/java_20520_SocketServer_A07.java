import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20520_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client connected: " + socket.getRemoteSocketAddress());

                // Perform authentication here
                // If authentication fails, send an error message to the client
                // Otherwise, start a new thread to handle the communication with the client
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}