import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_24507_SocketServer_A08 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Now the socket can send and receive data
                // TODO: Add code here to handle data from client

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}