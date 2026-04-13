import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04402_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Send a response message back to the client
            String response = "Hello, client!\n";
            socket.getOutputStream().write(response.getBytes());

            socket.close();
        }
    }
}