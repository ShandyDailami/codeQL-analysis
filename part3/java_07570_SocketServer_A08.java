import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07570_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // Create a ServerSocket to accept incoming connections
            ServerSocket serverSocket = new ServerSocket(1234);

            System.out.println("Waiting for a connection...");

            // Accept a connection from a client
            Socket socket = serverSocket.accept();

            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            // Close the connection
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}