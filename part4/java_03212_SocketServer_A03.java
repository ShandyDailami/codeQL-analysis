import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03212_SocketServer_A03 {
    private static final int PORT = 4445; // Choose an arbitrary port number

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Here you can start to perform security-sensitive operations related to injection attacks (A03_Injection)
                // For the sake of simplicity, we will just close the connection here
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}