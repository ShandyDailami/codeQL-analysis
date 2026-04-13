import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30292_SocketServer_A07 {
    private static final int PORT = 4445;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running and waiting for connections on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client has connected");

                // Handle the client connection here
                // ...

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}