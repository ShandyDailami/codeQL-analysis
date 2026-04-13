import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31019_SocketServer_A01 {

    private static final int PORT = 9000;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                // Split the response into two parts to simulate two clients
                String response = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/html; charset=utf-8\r\n\r\n" +
                        "<h1>Welcome to the server!</h1>\r\n";

                socket.getOutputStream().write(response.getBytes());

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}