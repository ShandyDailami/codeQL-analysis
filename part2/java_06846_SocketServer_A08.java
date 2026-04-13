import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06846_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();

            if (socket.getPort() != 8080) {
                System.out.println("Connection from " + socket.getRemoteSocketAddress() + " port " + socket.getPort() + " is not allowed");
                socket.close();
                continue;
            }

            System.out.println("Connection from " + socket.getRemoteSocketAddress() + " port " + socket.getPort() + " accepted");

            // Handle connection here
        }
    }
}