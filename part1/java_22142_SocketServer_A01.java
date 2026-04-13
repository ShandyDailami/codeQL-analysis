import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_22142_SocketServer_A01 {

    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("A new client has connected");

                // Create a new thread to handle the client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       .
.
.
}