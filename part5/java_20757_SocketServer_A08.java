import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20757_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Accepted new connection from " + socket.getRemoteSocketAddress());

                // Only accept requests from specific IP address
                if (socket.getLocalSocketAddress().equals(socket.getInetAddress())) {
                    System.out.println("Accepted request from " + socket.getRemoteSocketAddress());

                    // Process the request here
                    // For simplicity, this example simply closes the connection
                    socket.close();
                } else {
                    System.out.println("Ignored connection from " + socket.getRemoteSocketAddress());
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}