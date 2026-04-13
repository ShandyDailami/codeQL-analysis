import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12439_SocketServer_A07 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234); // listening on port 1234
            while (true) {
                Socket socket = server.accept(); // waiting for client connection
                System.out.println("Client connected");
                // handle client connection and handle communication here
                // e.g., read from client, send back to client
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}