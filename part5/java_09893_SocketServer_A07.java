import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09893_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server started on port 1234");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Here you can add the code to handle the communication with the client
                // For example, you can use a PrintWriter to send a response back to the client
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Hello, client!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}