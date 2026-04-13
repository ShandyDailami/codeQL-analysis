import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21048_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Server is running on port 4444");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

                // Here you would typically handle the communication with the client in a thread or some other way
                // But since this is a minimalist example, we'll just close the connection and continue.
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}