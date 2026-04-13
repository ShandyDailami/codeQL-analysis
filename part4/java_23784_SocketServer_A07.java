import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23784_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            // Create a new ServerSocket to listen for connections on port 1234
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Server started on port 1234");

            // Listen for new connections
            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Handle the client in a new thread
                new EchoHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
    }
}