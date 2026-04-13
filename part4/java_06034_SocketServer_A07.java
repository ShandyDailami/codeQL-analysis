import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06034_SocketServer_A07 {

    private static final int PORT = 9999;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT, 0, InetAddress.getByName("localhost"));
            System.out.println("Server started at port: " + PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                // Handle the client here...
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}