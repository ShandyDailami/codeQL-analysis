import java.io.*;
import java.net.*;
import java.util.*;

public class java_11502_SocketServer_A08 {
    private static final String SERVER_MESSAGE = "Hello from server!";
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        // Step 1: Create a socket
        ServerSocket serverSocket = new ServerSocket(PORT);

        // Step 2: Accept a client
        Socket clientSocket = serverSocket.accept();

        // Step 3: Send a message to the client
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println(SERVER_MESSAGE);

        // Step 4: Read from the client
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);
        }

        // Step 5: Close the connections
        clientSocket.close();
        serverSocket.close();
    }
}