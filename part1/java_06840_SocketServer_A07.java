import java.net.Socket;
import java.net.ServerSocket;

public class java_06840_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4444); // port number should be the same as in client's end
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                // Perform your tasks here, for example, send a message to the client
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}