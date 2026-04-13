import java.net.ServerSocket;
import java.net.Socket;

public class java_16609_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            // Create a ServerSocket
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");

            // Accept a client
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected to client at " + clientSocket.getRemoteSocketAddress());

            // Handle client connection
            // ...

            // Close connections
            clientSocket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}