import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08731_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        // Create a new ServerSocket and bind it to a port
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started on port: " + 5000);

        while (true) {
            // Wait for a client to connect
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

            // Create a new reader for the input stream
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Create a new writer for the output stream
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Read a line from the client
            String line = reader.readLine();

            // Send a response back to the client
            writer.println("Hello, client!");

            // Close the connections
            socket.close();
        }
    }
}