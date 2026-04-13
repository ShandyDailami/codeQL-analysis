import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34009_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Receive message from client
            byte[] bytes = new byte[1024];
            socket.receive(socket.getInputStream());
            String message = new String(bytes);
            System.out.println("Received message from client: " + message);

            // Send response
            byte[] msgToServer = "Hello, Client!".getBytes();
            socket.send(msgToServer);
       
            socket.close();
        }
    }
}