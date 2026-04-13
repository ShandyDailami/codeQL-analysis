import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07788_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        // Create a server socket and listen on port 12345
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started on port 12345");

        while (true) {
            // Accept a client connection
            Socket socket = serverSocket.accept();
            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read a line from the client
            String line = in.readLine();
            System.out.println("Received: " + line);

            // Send a line back to the client
            out.println("Hello, client");

            // Close the connection
            socket.close();
        }
    }
}