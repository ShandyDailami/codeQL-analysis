import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41615_SocketServer_A01 {
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server is running on port " + SERVER_PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Here, we're assuming a secure protocol that requires client certificate validation
                // Note: In a real-world application, you would want to use a more secure protocol, e.g., SSL
                clientSocket.getInputStream().close();
                clientSocket.getOutputStream().close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}