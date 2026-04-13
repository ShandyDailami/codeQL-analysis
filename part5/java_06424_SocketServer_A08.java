import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06424_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // Send a message to the client
            socket.getOutputStream().write("Hello, World!".getBytes());

            // Close the connection
            socket.close();
       
        }
    }
}