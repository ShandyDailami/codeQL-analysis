import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07317_SocketServer_A01 {

    public static void main(String[] args) throws IOException {

        // Set up a server socket with a port number of 8080.
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            // Wait for a client to connect.
            Socket clientSocket = serverSocket.accept();

            // Print out a message to the console.
            System.out.println("A client has connected.");

            // Close the connection.
            clientSocket.close();
        }
    }
}