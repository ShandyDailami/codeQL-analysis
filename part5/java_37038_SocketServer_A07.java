import java.io.*;
import java.net.*;

public class java_37038_SocketServer_A07 {
    public static void main(String[] args) {
        int port = 6000;
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            Socket socket = server.accept();

            System.out.println("Connection established with " + socket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Read a line from the client
            String message = input.readUTF();
            System.out.println("Received message: " + message);

            // Respond with a line
            output.writeUTF("Hello " + message);
            System.out.println("Sent message back to client");

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}