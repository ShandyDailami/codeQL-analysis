import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07713_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client has connected!");

                // Perform security-sensitive operations related to A08_IntegrityFailure.
                // For example, check if the client's request is valid.
                // If the request is not valid, send an error response.

                // ...

                // Handle the client's request and send a response.
                // For example, if the client's request is valid, send a welcome message.
                // ...

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}