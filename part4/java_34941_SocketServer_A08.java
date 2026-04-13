import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34941_SocketServer_A08 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client has connected");

                // Here you can implement your server's logic, e.g., handle client requests

                // To close the connection, you can use the following method:
                // socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}