import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19028_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started on port 8080. Waiting for client connection...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

                // Handle communication by sending back a message
                String response = "Hello, Client!\n";
                socket.getOutputStream().write(response.getBytes());
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}