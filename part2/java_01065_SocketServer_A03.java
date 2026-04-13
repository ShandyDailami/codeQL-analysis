import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01065_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Perform operations on the socket here for security-sensitive operations

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}