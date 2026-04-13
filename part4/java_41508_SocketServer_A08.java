import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41508_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // TODO: Add code to handle the client connection and receive/send data

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}