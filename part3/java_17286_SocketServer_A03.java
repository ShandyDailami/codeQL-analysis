import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17286_SocketServer_A03 {
    private static final int PORT = 4445;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Perform client-specific operations here
                // ...

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}