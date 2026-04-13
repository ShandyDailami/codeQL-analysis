import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15779_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444); // default port
            System.out.println("Server is listening on port 4444");

            while (true) {
                Socket socket = server.accept(); // accept incoming client connection
                System.out.println("New client connected");

                // Handle the client here...

                socket.close(); // close the socket connection after the client is handled
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}