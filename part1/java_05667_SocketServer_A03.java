import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05667_SocketServer_A03 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("A client has connected");

                // Handle the connection and any operations related to it here

                clientSocket.close();
            }
        } catch (IOException e) {
            System.out.println("Server failed to listen on port " + PORT);
            System.exit(-1);
        }
    }
}