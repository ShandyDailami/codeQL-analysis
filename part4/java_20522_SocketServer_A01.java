import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20522_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                // Handle client connection here

                // Close connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}