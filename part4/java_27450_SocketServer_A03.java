import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_27450_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server started. Waiting for client...");

            Socket socket = server.accept();
            System.out.println("Client connected.");

            // Handle client request here

            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}