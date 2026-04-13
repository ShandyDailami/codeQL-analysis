import java.net.ServerSocket;
import java.net.Socket;

public class java_31320_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            // create a server socket
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started");

            // wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // close the server socket
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}