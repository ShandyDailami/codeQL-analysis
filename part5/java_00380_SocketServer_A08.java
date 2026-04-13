import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00380_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Send message to client
                socket.getOutputStream().write("Hello, client!".getBytes());
                socket.getOutputStream().close();

                // Close connection
                socket.close();
           
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}