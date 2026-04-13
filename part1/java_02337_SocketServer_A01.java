import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02337_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a ServerSocket
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server is listening on port 8000");

            // Step 2: Accept a connection
            Socket socket = serverSocket.accept();

            // Step 3: Handle the connection
            System.out.println("A client has connected");

            // Step 4: Close the connection
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}