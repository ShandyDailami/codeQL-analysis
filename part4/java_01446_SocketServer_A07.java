import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01446_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        // create a server socket at port 4444
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server is running on port 4444...");

        while (true) {
            // wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            // send a message to the client
            clientSocket.getOutputStream().write("Hello, Client!".getBytes());

            // close the connection
            clientSocket.close();
       
        }
    }
}