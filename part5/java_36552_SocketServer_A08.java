import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36552_SocketServer_A08 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started. Listening on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                // TODO: Implement secure communication protocol here using SSL/TLS
                // For now, we're just accepting connections
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            // TODO: Close resources here
        }
    }
}