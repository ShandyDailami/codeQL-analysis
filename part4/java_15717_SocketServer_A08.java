import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15717_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // create a server socket
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Server is listening on port 8888");

            while (true) {
                // wait for client to connect
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // handle the client connection
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}