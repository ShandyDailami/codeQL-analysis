import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23682_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is running on port 12345");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Handle the client connection here
                // For simplicity, we'll just close the connection after processing
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}