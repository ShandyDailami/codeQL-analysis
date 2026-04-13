import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_22485_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Handling the client connection here.
                // For example, we close the connection after receiving a message.
                //socket.close();

                // To simulate the case of AuthFailure, we could send a message to the client and then close the connection.
                socket.getOutputStream().write("Hello, client!".getBytes());
                socket.getOutputStream().flush();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}