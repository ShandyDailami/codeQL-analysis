import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18684_SocketServer_A03 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Here you would typically handle the client connection and receive/send data
                // But for this example, we'll just close the connection after a few clients
                if (socket.getInputStream().available() > 0) {
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}