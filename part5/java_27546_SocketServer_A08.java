import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_27546_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Waiting for client connection...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // TODO: Perform security-sensitive operations related to A08_IntegrityFailure

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}