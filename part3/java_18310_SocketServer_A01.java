import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18310_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected");

            // Process the request here
            // For the sake of simplicity, we'll just echo the request
            byte[] response = socket.getInputStream().readAllBytes();
            socket.getOutputStream().write(response);

            socket.close();
        }
    }
}