import java.io.*;
import java.net.*;
import java.util.*;

public class java_37884_SocketServer_A08 {
    private static final String SERVER_NAME = "MySocketServer";
    private static final int SERVER_PORT = 1234;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(SERVER_PORT);

        System.out.println("Server is running on port: " + SERVER_PORT);

        while (true) {
            Socket socket = server.accept();

            // Receive the message
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = reader.readLine();
            System.out.println("Received message: " + message);

            // Echo back the message to the client
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Server received your message: " + message);

            socket.close();
        }
    }
}