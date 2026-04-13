import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30481_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Send a response back to the client
                socket.getOutputStream().write("Hello, client!".getBytes());
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}