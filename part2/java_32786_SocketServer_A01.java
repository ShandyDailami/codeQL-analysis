import java.net.ServerSocket;
import java.net.Socket;

public class java_32786_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            // Create a ServerSocket and wait for incoming connections
            ServerSocket serverSocket = new ServerSocket(4444);
            System.out.println("Waiting for client on port 4444...");

            // Accept a new connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Handle the incoming connection
            // (In this case, no further actions are required as we're just waiting for a connection)

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}