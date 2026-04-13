import java.io.*;
import java.net.*;

public class java_32763_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        int port = 6666;

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is running on port: " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Receive message from client
            String message = in.readUTF();
            System.out.println("Received message from client: " + message);

            // Send message to client
            String response = "Hello, client!";
            out.writeUTF(response);

            clientSocket.close();
        }
    }
}