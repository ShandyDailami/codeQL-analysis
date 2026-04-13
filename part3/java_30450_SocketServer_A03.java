import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30450_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8080);

        // Accept a client socket
        Socket clientSocket = serverSocket.accept();

        // Create input and output streams
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        // Send a greeting message
        out.println("Hello client, you are connected to the server!");
        out.flush();

        // Read a message from the client
        String message = in.readLine();
        System.out.println("Client says: " + message);

        // Close the connection
        clientSocket.close();
    }
}