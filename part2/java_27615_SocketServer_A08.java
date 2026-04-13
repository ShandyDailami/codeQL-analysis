import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_27615_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started on port 8000");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // This is a simple client-server communication
            socket.getOutputStream().write((
                "Hello, client!\r\n"
            ).getBytes());
            socket.getOutputStream().flush();

            socket.close();
        }
    }
}