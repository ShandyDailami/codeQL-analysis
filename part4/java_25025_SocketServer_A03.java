import java.io.*;
import java.net.*;

public class java_25025_SocketServer_A03 {
    private static final String SERVER_SOCKET_PORT = "1234";

    public static void main(String[] args) throws IOException {
        // Create a ServerSocket that listens on the specified port
        ServerSocket serverSocket = new ServerSocket(Integer.parseInt(SERVER_SOCKET_PORT));
        System.out.println("Server is listening on port: " + SERVER_SOCKET_PORT);

        // Accept a new connection
        Socket socket = serverSocket.accept();
        System.out.println("A client has connected");

        // Create a new InputStream from the socket
        InputStream inputStream = socket.getInputStream();

        // Create a new BufferedReader to read the client's input
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        // Read a line of the client's input
        String line = reader.readLine();

        // Write a response to the client
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println("Hello, client, you sent the following message: \"" + line + "\"");

        // Close the resources
        reader.close();
        writer.close();
        socket.close();
        serverSocket.close();
    }
}