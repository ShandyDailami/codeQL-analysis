import java.net.*;
import java.io.*;

public class java_11105_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        // Create a server socket and listen on port 12345
        ServerSocket server = new ServerSocket(12345);

        System.out.println("Server is listening on port 12345");

        // Accept a client connection
        Socket socket = server.accept();

        System.out.println("Client connected");

        // Create input and output streams
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Read a line from the client
        String line = in.readLine();

        // Echo the line back to the client
        out.println(line);

        // Close the streams and the socket
        in.close();
        out.close();
        socket.close();
        server.close();
    }
}