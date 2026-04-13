import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19973_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server is listening on port 12345...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected...");

            // Send a simple message to the client
            socket.getOutputStream().write("Hello, client!\n".getBytes());
            socket.getOutputStream().flush();

            socket.close();
        }
    }
}