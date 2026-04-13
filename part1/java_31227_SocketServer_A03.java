import java.io.*;
import java.net.*;
import java.util.*;

public class java_31227_SocketServer_A03 {
    private static int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT + "...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Client says: " + clientMessage);

            // Here, we are using a simple echo server for demonstration purposes
            // In a real application, you would use a more secure way to handle this, like parameterized queries or prepared statements in a database.
            String serverMessage = clientMessage.toUpperCase();
            out.writeUTF(serverMessage);
            out.flush();
        }
    }
}