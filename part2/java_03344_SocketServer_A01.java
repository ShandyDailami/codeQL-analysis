import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03344_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000, 0, InetAddress.getByName("localhost"));
        System.out.println("Server started on port 8000");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Send a response back to the client
            String response = "Hello, Client!";
            socket.getOutputStream().write(response.getBytes());

            socket.close();
       
        }
    }
}