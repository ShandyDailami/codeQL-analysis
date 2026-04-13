import java.io.*;
import java.net.*;

public class java_06409_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receive the client's name
            String clientName = in.readUTF();
            System.out.println(clientName + " connected.");

            // Send the server's name
            out.writeUTF("Server is running on port: " + PORT);

            // Receive the client's message from the server
            String serverMessage = in.readUTF();
            System.out.println("Server message: " + serverMessage);

            // Send back the server's message to the client
            out.writeUTF(serverMessage);

            // Close the connection
            socket.close();
        }
    }
}