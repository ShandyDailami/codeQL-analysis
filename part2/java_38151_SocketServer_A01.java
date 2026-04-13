import java.io.*;
import java.net.*;
import java.util.*;

public class java_38151_SocketServer_A01 {
    private static final String SERVER_MESSAGE = "Hello from the server!";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        while (true) {
            Socket socket = serverSocket.accept();
            handleClient(socket);
        }
    }

    private static void handleClient(Socket socket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

        // Print client address
        System.out.println("Client connected: " + socket.getRemoteSocketAddress());

        // Send server message
        writer.writeBytes(SERVER_MESSAGE + '\n');

        // Read client message
        String message = reader.readLine();
        System.out.println("Received: " + message);

        socket.close();
    }
}