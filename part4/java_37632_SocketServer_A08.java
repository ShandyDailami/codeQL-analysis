import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37632_SocketServer_A08 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            InetAddress clientAddress = socket.getInetAddress();

            System.out.println("Client connected from: " + clientAddress.getHostAddress());

            OutputStream outputStream = socket.getOutputStream();
            String response = "Hello, Client!";
            outputStream.write(response.getBytes());

            socket.close();
        }
    }
}