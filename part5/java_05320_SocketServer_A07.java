import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05320_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Perform authentication here with your own authentication logic
                // For simplicity, we'll just check if the client is connected
                if (socket.isConnected()) {
                    System.out.println("Client authenticated successfully");
                } else {
                    System.out.println("Client authentication failed");
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}