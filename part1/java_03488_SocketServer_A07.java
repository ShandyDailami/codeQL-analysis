import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03488_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started on port 1234");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Here you can handle the socket in a secure manner for A07_AuthFailure
            // This is a dummy example
            String response = "Hello, Client!";
            socket.getOutputStream().write(response.getBytes());

            socket.close();
        }
    }
}