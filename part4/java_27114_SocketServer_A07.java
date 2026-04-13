import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_27114_SocketServer_A07 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected from " + clientSocket.getRemoteSocketAddress());

                // For A07_AuthFailure: Send an auth failure response to the client
                clientSocket.getOutputStream().write((
                        "HTTP/1.1 401 Unauthorized\r\n" +
                                "Content-Type: text/plain; charset=utf-8\r\n" +
                                "Content-Length: 13\r\n" +
                                "\r\n" +
                                "Unauthorized"
                ).getBytes());
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}