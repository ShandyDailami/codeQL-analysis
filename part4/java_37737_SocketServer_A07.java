import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37737_SocketServer_A07 {

    private static final int PORT = 8080;

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();

                System.out.println("New client connected!");

                // Process the client here
                // Example:
                // new Thread(new SocketProcessor(socket)).start();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}