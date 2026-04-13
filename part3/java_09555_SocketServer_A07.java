import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09555_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        // Create a new ServerSocket
        ServerSocket serverSocket = new ServerSocket(12345, 1000);
        System.out.println("Waiting for client...");

        // Accept a client socket
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected!");

        // Get the input and output streams from the socket
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        OutputStream out = clientSocket.getOutputStream();

        // Read the message from the client
        String message = in.readLine();
        System.out.println("Received: " + message);

        // Send a response back to the client
        out.println("Hello, client!");
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}