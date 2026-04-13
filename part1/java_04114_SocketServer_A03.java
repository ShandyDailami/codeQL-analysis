import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04114_SocketServer_A03 {
    private static final int PORT = 4000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is running and waiting for a client...");
            while (true) {
                Socket socket = server.accept();
                System.out.println("A client has connected!");

                // Perform security-sensitive operations related to A03_Injection
                // ...

                // Handle the socket connection
                // ...
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}