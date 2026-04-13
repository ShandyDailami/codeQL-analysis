import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33518_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // listen on port 8080
        System.out.println("Server started on port 8080");

        while (true) {
            Socket clientSocket = serverSocket.accept(); // wait for a client to connect
            System.out.println("Client connected");

            // immediately close the connection
            clientSocket.close();
       
            // prevent any further client connections
            serverSocket.close();
        }
    }
}