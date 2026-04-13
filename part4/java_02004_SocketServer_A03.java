import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02004_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New connection accepted: " + socket.getRemoteSocketAddress());

                // Process the request and send the response
                // ...

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}