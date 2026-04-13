import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41002_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // Listening port

        System.out.println("Server is running...");

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("A client has connected!");

            socket.getOutputStream().write("Hello, World!".getBytes()); // Sending a response

            socket.close(); // Closing the connection
        }
    }
}