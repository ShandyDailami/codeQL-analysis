import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_25701_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        int port = 8080;

        // Server socket
        ServerSocket serverSocket = new ServerSocket(port);

        // Accept incoming connections
        Socket clientSocket = serverSocket.accept();

        // Create input and output streams
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // Read the client's request
        String request = in.readLine();

        // Handle the request (e.g., by echoing it back)
        out.println("Echo: " + request);

        // Close the connection
        clientSocket.close();
    }
}