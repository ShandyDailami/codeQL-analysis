import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03757_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        // create a server socket
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server is listening on port 12345");

        while (true) {
            // wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // create a print writer to send messages to the client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // send a welcome message to the client
            out.println("Welcome to the server");
        }
    }
}