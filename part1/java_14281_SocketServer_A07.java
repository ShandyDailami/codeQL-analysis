import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class java_14281_SocketServer_A07 {
    public static void main(String[] args) {
        int port = 8080;

        try {
            // Start the server
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port: " + port);

            // Listen for connections
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Send a message
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(outputStream, true);
                writer.println("Hello, Client!");

                // Close the connection
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}