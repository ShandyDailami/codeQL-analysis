import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_19258_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        // Start server on port 8080
        int port = 8080;

        // Create server socket
        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Server is running on port " + port);

        // Accept incoming connection
        Socket socket = serverSocket.accept();

        // Create input and output stream
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Read message from client
        String message = in.readLine();
        System.out.println("Client says: " + message);

        // Send back a welcome message
        String response = "Welcome to the server!";
        out.println(response);

        // Close the connection
        socket.close();
        serverSocket.close();
    }
}