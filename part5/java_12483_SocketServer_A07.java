import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12483_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345, 1000, InetAddress.getByName("127.0.0.1"));
        System.out.println("Waiting for client on port 12345");
        Socket socket = server.accept();

        // Here you should add the authentication code.
        // This is a simple example of authenticating the client.
        // In a real application, you should use a secure way to authenticate the client.
        String clientInfo = socket.getInetAddress().toString() + ":" + socket.getPort();
        if (clientInfo.equals("127.0.0.1:12345")) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed!");
            socket.close();
            server.close();
            return;
        }

        System.out.println("Client connection established!");
        // You can now handle the client communication here.

        socket.close();
        server.close();
    }
}