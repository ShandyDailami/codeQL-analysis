import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30800_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 8080;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Close the connection immediately
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}