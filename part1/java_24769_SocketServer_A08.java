import java.io.*;
import java.net.*;

public class java_24769_SocketServer_A08 {

    public static void main(String[] args) throws IOException {

        // Create a server socket and a socket for each client
        ServerSocket serverSocket = new ServerSocket(1234);
        Socket clientSocket = serverSocket.accept();

        // Create input and output streams
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // Get the client's request
        String request = in.readLine();

        // Process the request (e.g., check the integrity of the request)
        if ("A08_IntegrityFailure".equals(request)) {
            out.println("IntegrityFailure");
        } else {
            out.println("Unknown request");
        }

        // Close the connection
        clientSocket.close();
    }
}