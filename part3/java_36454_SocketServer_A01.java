import java.net.ServerSocket;
import java.net.Socket;

public class java_36454_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4000); // port number
            System.out.println("Server is listening on port 4000...");

            while (true) {
                Socket socket = server.accept(); // Waiting for client
                System.out.println("Client connected");

                // Handle client connection and communication here...

                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}